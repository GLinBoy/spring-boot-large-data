package com.glinboy.test.largedata.client

import com.glinboy.test.largedata.dto.TweetNewsResponse

interface DataProviderService {
    fun invokeApiProvider(): List<TweetNewsResponse>
}