package com.glinboy.largedata.dataprocessor.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.kafka.test.EmbeddedKafkaBroker

@Profile("dev")
@Configuration
class KafkaConfig {

    @Bean
    fun broker(): EmbeddedKafkaBroker = EmbeddedKafkaBroker(1)
        .kafkaPorts(9092)

}
