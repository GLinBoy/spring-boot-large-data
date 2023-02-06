package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.entity.Review
import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.dataprocessor.service.processor.SaveProcess
import com.glinboy.largedata.shared.dto.ReviewDTO

class SaveProcessImpl(private val reviewRepository: ReviewRepository) :
    SaveProcess<ReviewDTO>,
    AbstractProcess<ReviewDTO>() {

    override fun job(reviewDTO: ReviewDTO) {
        reviewRepository.save(
            Review(
                null,
                reviewDTO.reviewDate,
                reviewDTO.movieId,
                reviewDTO.userId,
                reviewDTO.isSpoiler,
                reviewDTO.reviewText,
                reviewDTO.rating,
                reviewDTO.reviewSummary
            )
        )
    }
}
