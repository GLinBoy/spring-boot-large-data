package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.entity.Review
import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.dataprocessor.service.processor.SaveProcess
import com.glinboy.largedata.shared.dto.ReviewDTO

class SaveProcessNormalImpl(private val reviewRepository: ReviewRepository) :
    SaveProcess<List<ReviewDTO>>,
    AbstractProcess<List<ReviewDTO>>() {

    override fun job(reviewDTOs: List<ReviewDTO>) {
        reviewRepository.saveAll(
            reviewDTOs.map {
                Review(
                    null,
                    it.reviewDate,
                    it.movieId,
                    it.userId,
                    it.isSpoiler,
                    it.reviewText,
                    it.rating,
                    it.reviewSummary
                )
            }
        )
    }
}
