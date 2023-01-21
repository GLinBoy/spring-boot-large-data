package com.glinboy.test.largedata.service.impl

import com.glinboy.test.largedata.client.DataProviderService
import com.glinboy.test.largedata.service.ReviewsServiceApi
import org.springframework.stereotype.Service

@Service
class ReviewsServiceImpl(private val dataProviderService: DataProviderService): ReviewsServiceApi {
}
