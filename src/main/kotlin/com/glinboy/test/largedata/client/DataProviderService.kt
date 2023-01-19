package com.glinboy.test.largedata.client

import com.glinboy.test.largedata.dto.ReviewDTO

interface DataProviderService {
    fun invokeApiProvider(): List<ReviewDTO>
}
