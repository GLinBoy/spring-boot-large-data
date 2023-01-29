package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.dataprocessor.entity.Review
import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.shared.dto.ReviewDTO

class SaveProcess(private val reviewRepository: ReviewRepository) : AbstractProcess<List<ReviewDTO>>() {

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
