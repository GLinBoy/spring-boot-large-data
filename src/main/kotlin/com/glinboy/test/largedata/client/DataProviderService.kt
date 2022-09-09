package com.glinboy.test.largedata.client

import com.glinboy.test.largedata.dto.TweetNewsResponseDTO

interface DataProviderService {
    fun invokeApiProvider(): List<TweetNewsResponseDTO>
}
