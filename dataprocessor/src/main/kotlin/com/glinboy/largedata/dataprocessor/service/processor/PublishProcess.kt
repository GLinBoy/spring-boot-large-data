package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class PublishProcess(private val kafkaTemplate: KafkaTemplate<Object, ReviewDTO>):
    AbstractProcess<List<ReviewDTO>>() {

    override fun job(reviewDTOs: List<ReviewDTO>) {
        reviewDTOs.map {
            kafkaTemplate.send("REVIEW-TOPIC", it)
        }
    }
}
