package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.dataprocessor.service.processor.DeleteProcess
import com.glinboy.largedata.shared.dto.ReviewDTO

class DeleteProcessImpl(private val reviewRepository: ReviewRepository) :
    DeleteProcess<ReviewDTO>,
    AbstractProcess<ReviewDTO>() {
    override fun job(data: ReviewDTO) {
        reviewRepository.deleteAllInBatch()
    }
}
