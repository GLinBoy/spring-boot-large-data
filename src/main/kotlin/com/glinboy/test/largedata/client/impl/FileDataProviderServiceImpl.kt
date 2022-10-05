package com.glinboy.test.largedata.client.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.glinboy.test.largedata.client.DataProviderService
import com.glinboy.test.largedata.dto.TweetNewsResponseDTO
import org.springframework.stereotype.Service

@Service
class FileDataProviderServiceImpl : DataProviderService {

    val mapper = jacksonObjectMapper()

    override fun invokeApiProvider(): List<TweetNewsResponseDTO> = mapper
        .readValue(
            FileDataProviderServiceImpl::class.java
                .getResource("/data/final_mini_news.json")?.readText() ?: "[]"
        )
}
