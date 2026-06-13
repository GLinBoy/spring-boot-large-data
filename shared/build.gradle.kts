plugins {
	kotlin("jvm") version "2.3.21"
}

group = "com.glinboy.largedata"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

val jacksonVersion = "2.20.1"

dependencies {
	implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
