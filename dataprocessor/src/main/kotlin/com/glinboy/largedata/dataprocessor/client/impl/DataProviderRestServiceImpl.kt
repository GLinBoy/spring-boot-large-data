package com.glinboy.largedata.dataprocessor.client.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DataProviderRestServiceImpl: DataProviderServiceApi {

    private val log = LoggerFactory.getLogger(javaClass)
    private val rt = RestTemplate()

    @Value("\${application.data-provider-url.sample}")
    lateinit var dataSampleUrl: String

    @Value("\${application.data-provider-url.all}")
    lateinit var dataUrl: String

    override fun getSampleData(): List<ReviewDTO> {
        val response = rt.exchange(dataSampleUrl, HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<ReviewDTO>>() {})
        log.info("Status code: ${response.statusCode}, Data count: ${response.body!!.size}")
        return response.body!!
    }

    override fun getAllData(): List<ReviewDTO> {
        log.info(dataUrl)
        return listOf()
    }
}
