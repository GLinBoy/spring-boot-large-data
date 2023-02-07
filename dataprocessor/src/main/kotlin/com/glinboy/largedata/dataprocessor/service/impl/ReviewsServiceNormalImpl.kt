package com.glinboy.largedata.dataprocessor.service.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.dataprocessor.service.ReviewsServiceApi
import com.glinboy.largedata.dataprocessor.service.processor.Process
import com.glinboy.largedata.dataprocessor.service.processor.ReviewHandler
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service

@Service
@ConditionalOnProperty(value = ["application.mode"], havingValue = "normal", matchIfMissing = true)
class ReviewsServiceNormalImpl(
    private val dataProviderServiceApi: DataProviderServiceApi<List<ReviewDTO>>,
    private val reviewHandler: ReviewHandler<Process<List<ReviewDTO>>, List<ReviewDTO>>
) : ReviewsServiceApi {

    override fun fetchSampleReviews() {
        val reviewDTOs = dataProviderServiceApi.getSampleData()
        reviewHandler.getReviewHandlerChain().process(reviewDTOs)
    }

    override fun fetchAllData() {
        val reviewDTOs = dataProviderServiceApi.getAllData()
        reviewHandler.getReviewHandlerChain().process(reviewDTOs)
    }
}
