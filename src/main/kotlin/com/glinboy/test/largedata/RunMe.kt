package com.glinboy.test.largedata

import com.glinboy.test.largedata.client.DataProviderService
import com.glinboy.test.largedata.dto.ReviewDTO
import com.glinboy.test.largedata.entity.Review
import com.glinboy.test.largedata.repository.ReviewRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

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
                    it?.reviewDate,
                    it?.movieId,
                    it?.userId,
                    it?.isSpoiler,
                    it?.reviewText,
                    it?.rating,
                    it?.reviewSummary
                )
            }
        )
    }
}
