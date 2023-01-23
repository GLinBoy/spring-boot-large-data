package com.glinboy.largedata.dataprocessor.service.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderService
import com.glinboy.largedata.dataprocessor.service.ReviewsServiceApi
import org.springframework.stereotype.Service

@Service
class ReviewsServiceImpl(private val dataProviderService: DataProviderService): ReviewsServiceApi {
    override fun fetchSampleReviews() {
        dataProviderService.invokeApiProvider()
    }

    override fun fetchAllData() {
        dataProviderService.invokeApiProvider()
    }
}
