package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.stereotype.Component

@Component
class DeleteProcess(private val reviewRepository: ReviewRepository) :
    AbstractProcess<ReviewDTO>() {
    override fun job(data: ReviewDTO) {
        reviewRepository.deleteAllInBatch()
    }
}
