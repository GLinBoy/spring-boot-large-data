package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.service.processor.PublishProcess
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate

class PublishProcessImpl(private val kafkaTemplate: KafkaTemplate<String, ReviewDTO>) :
    PublishProcess<ReviewDTO>,
    AbstractProcess<ReviewDTO>() {

    @Value("\${application.kafka-topic}")
    lateinit var topic: String

    override fun job(reviewDTO: ReviewDTO) {
        kafkaTemplate.send(topic, reviewDTO)
    }
}
