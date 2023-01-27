package com.glinboy.largedata.dataprocessor.service.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.dataprocessor.service.ReviewsServiceApi
import org.springframework.stereotype.Service

@Service
class ReviewsServiceImpl(private val dataProviderServiceApi: DataProviderServiceApi): ReviewsServiceApi {
    override fun fetchSampleReviews() {
        dataProviderServiceApi.getSampleData()
    }

    override fun fetchAllData() {
        dataProviderServiceApi.getAllData()
    }
}
