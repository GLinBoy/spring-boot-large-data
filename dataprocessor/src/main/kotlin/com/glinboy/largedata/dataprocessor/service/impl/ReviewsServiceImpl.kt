package com.glinboy.largedata.dataprocessor.service.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.dataprocessor.service.ReviewsServiceApi
import com.glinboy.largedata.dataprocessor.service.processor.ReviewHandler
import org.springframework.stereotype.Service

@Service
class ReviewsServiceImpl(
    private val dataProviderServiceApi: DataProviderServiceApi,
    private val reviewHandler: ReviewHandler
): ReviewsServiceApi {
    override fun fetchSampleReviews() {
        val reviewDTOs = dataProviderServiceApi.getSampleData()
        reviewHandler.getReviewHandlerChain().process(reviewDTOs)
    }

    override fun fetchAllData() {
        val reviewDTOs = dataProviderServiceApi.getAllData()
        reviewHandler.getReviewHandlerChain().process(reviewDTOs)
    }
}
