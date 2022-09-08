package com.glinboy.test.largedata.client.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.glinboy.test.largedata.client.DataProviderService
import com.glinboy.test.largedata.dto.TweetNewsResponse
import org.springframework.stereotype.Service

@Service
class FileDataProviderServiceImpl : DataProviderService {

    val mapper = jacksonObjectMapper()

    override fun invokeApiProvider(): List<TweetNewsResponse> = mapper
        .readValue(
            FileDataProviderServiceImpl::class.java
                .getResource("/data/final_mini_news.json")?.readText() ?: "[]",
            List::class.java
        ) as List<TweetNewsResponse>
}
