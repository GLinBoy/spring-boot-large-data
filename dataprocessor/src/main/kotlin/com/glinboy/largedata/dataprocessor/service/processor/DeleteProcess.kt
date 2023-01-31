package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.stereotype.Component

@Component
class DeleteProcess(private val reviewRepository: ReviewRepository) :
    AbstractProcess<List<ReviewDTO>>() {
    override fun job(data: List<ReviewDTO>) {
        reviewRepository.deleteAllInBatch()
    }
}