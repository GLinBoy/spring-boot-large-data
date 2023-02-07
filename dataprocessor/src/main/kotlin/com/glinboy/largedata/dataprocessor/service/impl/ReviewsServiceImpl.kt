package com.glinboy.largedata.dataprocessor.service.impl

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.ObjectMapper
import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.dataprocessor.service.ReviewsServiceApi
import com.glinboy.largedata.dataprocessor.service.processor.Process
import com.glinboy.largedata.dataprocessor.service.processor.ReviewHandler
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service
import java.io.File

@Service
@ConditionalOnProperty(value = ["application.mode"], havingValue = "memory-efficient")
class ReviewsServiceImpl(
    private val dataProviderServiceApi: DataProviderServiceApi<File>,
    private val reviewHandler: ReviewHandler<Process<ReviewDTO>, ReviewDTO>,
    private val om: ObjectMapper,
    private val repository: ReviewRepository
): ReviewsServiceApi {

    private val jf: JsonFactory = JsonFactory()
    override fun fetchSampleReviews() {
        repository.deleteAllInBatch()
        processFile(dataProviderServiceApi.getSampleData())
    }

    override fun fetchAllData() {
        repository.deleteAllInBatch()
        processFile(dataProviderServiceApi.getAllData())
    }

    private fun processFile(file: File) {
        jf.createParser(file).use {
            it.nextToken()
            while (it.nextToken() != JsonToken.END_ARRAY) {
                val reviewDTO: ReviewDTO = om.readValue(it, ReviewDTO::class.java)
                reviewHandler.getReviewHandlerChain().process(reviewDTO)
            }
        }
    }
}
