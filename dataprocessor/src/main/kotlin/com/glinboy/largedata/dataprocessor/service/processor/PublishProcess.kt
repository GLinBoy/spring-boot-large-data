package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class PublishProcess(private val kafkaTemplate: KafkaTemplate<String, ReviewDTO>) :
    AbstractProcess<ReviewDTO>() {

    @Value("\${application.kafka-topic}")
    lateinit var topic: String

    override fun job(reviewDTO: ReviewDTO) {
        kafkaTemplate.send(topic, reviewDTO)
    }
}
