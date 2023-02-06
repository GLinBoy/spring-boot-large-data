package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.dataprocessor.service.processor.DeleteProcess
import com.glinboy.largedata.shared.dto.ReviewDTO

class DeleteProcessNormalImpl(private val reviewRepository: ReviewRepository) :
    DeleteProcess<List<ReviewDTO>>,
    AbstractProcess<List<ReviewDTO>>() {
    override fun job(data: List<ReviewDTO>) {
        reviewRepository.deleteAllInBatch()
    }
}
