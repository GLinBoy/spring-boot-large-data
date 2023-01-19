package com.glinboy.test.largedata.client.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.glinboy.test.largedata.client.DataProviderService
import com.glinboy.test.largedata.dto.ReviewDTO
import org.springframework.stereotype.Service

@Service
class FileDataProviderServiceImpl : DataProviderService {

    val mapper = jacksonObjectMapper()

    override fun invokeApiProvider(): List<ReviewDTO> = mapper.readValue(
        FileDataProviderServiceImpl::class.java
            .getResource("/data/IMDB_reviews.sample.json")?.readText() ?: "[]"
    )
}
