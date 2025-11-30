package com.glinboy.largedata.dataprocessor

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment
import java.net.InetAddress
import java.net.UnknownHostException

@SpringBootApplication
class DataProcessorApplication {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			val env = runApplication<DataProcessorApplication>(*args).environment
			logApplicationStartup(env)
		}

		@JvmStatic
		fun logApplicationStartup(env: Environment) {
			val log = LoggerFactory.getLogger(DataProcessorApplication::class.java)

			var protocol = "http"
			if (env.getProperty("server.ssl.key-store") != null) {
				protocol = "https"
			}
			val serverPort = env.getProperty("server.port")
			var contextPath = env.getProperty("server.servlet.context-path")
			if (contextPath.isNullOrBlank()) {
				contextPath = "/"
			}
			var hostAddress = "localhost"
			try {
				hostAddress = InetAddress.getLocalHost().hostAddress
			} catch (_: UnknownHostException) {
				log.warn("The host name could not be determined, using `localhost` as fallback")
			}
			log.info(
				"\n----------------------------------------------------------\n\t" +
					"Application '{}' is running! Access URLs:\n\t" +
					"Local: \t\t{}://localhost:{}{}\n\t" +
					"External: \t{}://{}:{}{}\n\t" +
					"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.activeProfiles
			)
		}
	}
}
