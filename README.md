# Large Data Processing with Limited Memory

Process ~1.5 GB of JSON data while keeping the Java application memory under ~750 MB. The repository contains two Spring Boot (Kotlin) applications that simulate a real scenario where you must ingest a very large third‑party API response efficiently and safely.

---

## Quick Summary (Non‑Technical Friendly)

There are two small programs:

1. dataprovider – Pretends to be an external service. It simply returns a big file when you ask for it.
2. dataprocessor – The real app. It requests that big file, replaces old records with new ones, and then broadcasts each review message to a Kafka stream for other systems to use.

Challenge: Load huge data without letting memory explode. Two strategies are implemented:

-   Normal mode: Load everything into memory first (simpler but heavy).
-   Memory‑efficient mode: Stream the file piece by piece from disk (slower, but low memory use).

You can switch modes with one property. The goal is to show why streaming design matters in cloud / Kubernetes environments with limited resources.

---

## High-Level Architecture

```
						(Simulated 3rd Party)
				+-------------------------+
				|      dataprovider       |  <-- Serves large JSON file
				+------------+------------+
										 |
 HTTP (JSON file)    |  sample/all
										 v
				+-------------------------+
				|      dataprocessor      |  <-- Fetch → Clean → Save → Publish
				+--+----------+-----------+
					 |          |
				 DB (H2/PG)  Kafka (topic: REVIEW-TOPIC)
```

Core pattern: Chain of Responsibility – each processing step is a handler in a pipeline (fetch, delete old data, persist new, publish to Kafka).

---

## Modules

| Module        | Port | Purpose                                                       |
| ------------- | ---- | ------------------------------------------------------------- |
| dataprovider  | 8282 | Serves large or sample JSON payloads from resources/data      |
| dataprocessor | 8181 | Fetches data, processes it, stores it, publishes Kafka events |
| shared        | –    | Shared classes/utilities                                      |

### dataprovider

Endpoints:

-   `GET /api/data/sample` – Returns `IMDB_reviews.sample.json`
-   `GET /api/data/all` – Returns `IMDB_reviews.large.json` (stored compressed as `.xz` in Git)

Utility script: `data/editor.py` – Can build a smaller sample file from the large one.

### dataprocessor

Endpoints to trigger ingestion:

-   `POST /api/reviews/load/sample`
-   `POST /api/reviews/load/all`

Processing flow per trigger:

1. Download / stream JSON from dataprovider
2. Delete or logically clear old review data
3. Save fresh data (H2 in dev, PostgreSQL in prod)
4. Publish each review to Kafka topic `REVIEW-TOPIC`

Two implementations of the service layer:
| Mode Property (`application.mode`) | Implementation | Behavior |
|-----------------------------------|----------------|----------|
| `normal` | `ReviewsServiceNormalImpl` | Loads entire JSON into memory first |
| `memory-efficient` | `ReviewsServiceImpl` | Streams file via Jackson `JsonFactory` object-by-object |

Current default: `memory-efficient` (see `dataprocessor/src/main/resources/application.yml`).

---

## Tech Stack

-   Kotlin + Spring Boot 3.5.x (Java 21)
-   Jackson streaming API
-   Kafka (Confluent images for local dev)
-   H2 (dev) / PostgreSQL (prod profile)
-   Gradle Kotlin DSL
-   Optional tooling: VisualVM for memory & GC observation

---

## Getting Started

### 1. Clone

```bash
git clone https://github.com/GLinBoy/spring-boot-large-data.git
cd spring-boot-large-data
```

### 2. Prepare the Large Dataset

The repository ships with a compressed large file:

```
dataprovider/src/main/resources/data/IMDB_reviews.large.json.xz
```

Decompress it (keeps the original by default add `--keep` if desired):

```bash
xz -d dataprovider/src/main/resources/data/IMDB_reviews.large.json.xz
```

After this you should have:

```
dataprovider/src/main/resources/data/IMDB_reviews.large.json
```

Create / refresh the sample file (optional):

The helper script `editor.py` is very simple and does NOT take command‑line arguments. Open it if you want to change:

-   `main_file_name` (currently `IMDB_reviews.json` – you can rename the decompressed large file to this OR adjust the variable)
-   `mini_file_lines` (how many lines to copy for the sample)

Typical workflow:

```bash
cd dataprovider/src/main/resources/data
# (optional) make a copy / rename large file to expected name used by the script
cp IMDB_reviews.large.json IMDB_reviews.json
python editor.py
```

Uncomment `generate_mini_file()` inside the script if you also want the truncated raw lines file; by default it wraps existing lines into a JSON array via `convert_to_json`.

### 3. Infrastructure (Kafka & PostgreSQL)

For full functionality (Kafka publishing + prod DB), start the Docker stack:

```bash
docker compose -f docker/docker-compose.yml up -d
```

Services exposed:

-   Kafka broker: `localhost:9092`
-   PostgreSQL: `localhost:5432` (user: postgres / password: 1 / db: large_data)

If you only want to experiment with the ingestion logic and H2 in-memory DB, you can skip this and stay on the `dev` profile (default). Kafka publishing will still attempt to connect; start Kafka if you need to observe messages.

### 4. Build All Modules

```bash
./gradlew clean build
```

### 5. Run Applications

You can run them in separate terminals.

dataprovider (port 8282):

```bash
./gradlew :dataprovider:bootRun \
	-Dspring-boot.run.jvmArguments="-Xms256m -Xmx512m"
```

dataprocessor (port 8181) – memory‑efficient mode (default):

```bash
./gradlew :dataprocessor:bootRun \
	-Dspring-boot.run.jvmArguments="-Xms512m -Xmx750m"
```

To switch to normal (in‑memory) mode without editing files:

```bash
./gradlew :dataprocessor:bootRun \
	-Dspring-boot.run.jvmArguments="-Xms512m -Xmx750m" \
	-Dapplication.mode=normal
```

Or edit `dataprocessor/src/main/resources/application.yml` and set:

```yaml
application:
	mode: normal
```

### 6. Trigger Data Loads

Sample dataset:

```bash
curl -X POST http://localhost:8181/api/reviews/load/sample
```

Full dataset (large):

```bash
curl -X POST http://localhost:8181/api/reviews/load/all
```

Check provider directly:

```bash
curl -I http://localhost:8282/api/data/sample
curl -I http://localhost:8282/api/data/all
```

### 7. View Kafka Messages (optional)

Use a Kafka UI tool or CLI consumer:

```bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic REVIEW-TOPIC --from-beginning
```

### 8. Monitor Memory (VisualVM)

1. Start VisualVM.
2. Attach to the dataprocessor JVM (will appear under local applications).
3. Trigger a load and observe Heap usage difference between `normal` vs `memory-efficient`.

---

## Endpoint Reference

| Service       | Method | Path                     | Description                            |
| ------------- | ------ | ------------------------ | -------------------------------------- |
| dataprovider  | GET    | /api/data/sample         | Returns small JSON sample              |
| dataprovider  | GET    | /api/data/all            | Returns full large JSON                |
| dataprocessor | POST   | /api/reviews/load/sample | Triggers sample ingestion & publishing |
| dataprocessor | POST   | /api/reviews/load/all    | Triggers full ingestion & publishing   |

Health / Actuator (processor only, dev profile): `http://localhost:8181/actuator` (all exposed)

---

## Chain of Responsibility Steps

1. Fetch Handler – obtains stream (or full payload) from dataprovider.
2. Cleanup Handler – removes old data (strategy may vary by implementation / mode).
3. Persist Handler – writes each review to the DB (batch or per-item streaming logic in memory‑efficient mode).
4. Publish Handler – sends review events to Kafka.
5. Finalization – optional logging / metrics.

Each handler focuses on a single responsibility making it easy to swap implementations.

---

## Memory Strategy Explained

| Aspect     | Normal Mode                         | Memory‑Efficient Mode            |
| ---------- | ----------------------------------- | -------------------------------- |
| Loading    | Whole JSON array loaded into RAM    | Streamed via Jackson parser      |
| Peak Heap  | High (scales with file size)        | Stable (bounded by object batch) |
| Simplicity | Simple                              | Slightly more code               |
| Speed      | Often faster for small/medium files | More I/O bound, lower footprint  |

The streaming approach writes the raw HTTP response to a temporary file (or accesses as stream) and iterates tokens, constructing domain objects one at a time, persisting immediately – eliminating the need for a gigantic intermediate list.

---

## Profiles

| Profile       | DB           | How to Activate                                                          |
| ------------- | ------------ | ------------------------------------------------------------------------ |
| dev (default) | H2 in‑memory | Already active (`application-dev.yml`)                                   |
| prod          | PostgreSQL   | `-Dspring.profiles.active=prod` or env var `SPRING_PROFILES_ACTIVE=prod` |

---

## Running Tests

```bash
./gradlew test
```

---

## Troubleshooting

| Problem                         | Cause                           | Fix                                         |
| ------------------------------- | ------------------------------- | ------------------------------------------- |
| 404 on /api/data/all            | Large file not decompressed     | Decompress `.xz` file                       |
| OutOfMemoryError in normal mode | File exceeds heap               | Use `memory-efficient` mode or raise `-Xmx` |
| Kafka connection errors         | Kafka not started               | Run docker compose stack                    |
| PostgreSQL auth errors          | Wrong creds or container not up | Check compose file credentials              |

Logs contain detailed step markers; enable more logs by adjusting levels in `application-prod.yml` or dev profile.

---

## Future Ideas

-   Add backpressure & rate limiting
-   Add metrics (Micrometer, Prometheus)
-   Add retry & circuit breaker (Resilience4j)
-   Compress Kafka messages or use Avro/Schema Registry

---

## License

## Dataset Source & License

This project uses a dataset derived from the IMDB Spoiler Dataset available on Kaggle:

- IMDB Spoiler Dataset: https://www.kaggle.com/datasets/rmisra/imdb-spoiler-dataset

The dataset is provided under the Creative Commons Attribution 4.0 International (CC BY 4.0) license. That license applies ONLY to the dataset contents and NOT to the source code in this repository. Before redistributing or using the data commercially, review the Kaggle page and the full CC BY 4.0 terms: https://creativecommons.org/licenses/by/4.0/

Proper citation example (adapt as needed):

Rishabh Misra. IMDB Spoiler Dataset. Kaggle. CC BY 4.0.

If you replace the dataset with another source, update this section accordingly.

See [LICENSE.md](LICENSE.md).

---

## Contributing

PRs welcome: open an issue describing enhancement or bug. Keep memory‑efficient design principles in mind.

---

Happy streaming!
