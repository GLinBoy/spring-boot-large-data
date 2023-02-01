package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.dataprocessor.entity.Review
import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.stereotype.Component

@Component
class SaveProcess(private val reviewRepository: ReviewRepository) : AbstractProcess<ReviewDTO>() {

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
