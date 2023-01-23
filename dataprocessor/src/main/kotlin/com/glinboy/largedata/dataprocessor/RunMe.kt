package com.glinboy.largedata.dataprocessor

import com.glinboy.largedata.dataprocessor.client.DataProviderService
import com.glinboy.largedata.dataprocessor.dto.ReviewDTO
import com.glinboy.largedata.dataprocessor.entity.Review
import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

//@Component
class RunMe(
    private val dataProviderService: DataProviderService,
    private val reviewRepository: ReviewRepository
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @EventListener(ApplicationReadyEvent::class)
    fun run() {
        logger.info("Let's do some logic!")
        val all: List<ReviewDTO> = dataProviderService.invokeApiProvider()
        logger.info("---> Data count: {}", all.count())
        reviewRepository.saveAll(
            all.map {
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
