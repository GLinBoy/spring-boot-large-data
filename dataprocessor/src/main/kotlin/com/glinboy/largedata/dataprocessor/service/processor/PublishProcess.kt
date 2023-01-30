package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class PublishProcess(private val kafkaTemplate: KafkaTemplate<Object, ReviewDTO>):
    AbstractProcess<List<ReviewDTO>>() {

    @Value("\${application.kafka-topic}")
    lateinit var topic: String

    override fun job(reviewDTOs: List<ReviewDTO>) {
        reviewDTOs.map {
            kafkaTemplate.send(topic, it)
        }
    }
}
