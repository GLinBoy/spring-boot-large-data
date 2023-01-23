package com.glinboy.largedata.dataprocessor.client.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.glinboy.largedata.dataprocessor.client.DataProviderService
import com.glinboy.largedata.dataprocessor.dto.ReviewDTO
import org.springframework.stereotype.Service

@Service
class FileDataProviderServiceImpl : DataProviderService {

    val mapper = jacksonObjectMapper()

    override fun invokeApiProvider(): List<ReviewDTO> = mapper.readValue(
        FileDataProviderServiceImpl::class.java
            .getResource("/data/IMDB_reviews.sample.json")?.readText() ?: "[]"
    )
}
