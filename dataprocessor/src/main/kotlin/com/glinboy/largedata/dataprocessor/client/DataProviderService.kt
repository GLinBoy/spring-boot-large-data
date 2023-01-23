package com.glinboy.largedata.dataprocessor.client

import com.glinboy.largedata.dataprocessor.dto.ReviewDTO

interface DataProviderService {
    fun invokeApiProvider(): List<ReviewDTO>
}
