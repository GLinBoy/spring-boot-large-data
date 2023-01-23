package com.glinboy.largedata.dataprocessor.client

import com.glinboy.largedata.shared.dto.ReviewDTO

interface DataProviderService {
    fun invokeApiProvider(): List<ReviewDTO>
}
