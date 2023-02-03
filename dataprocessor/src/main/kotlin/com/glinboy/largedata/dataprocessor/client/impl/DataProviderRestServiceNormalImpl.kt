package com.glinboy.largedata.dataprocessor.client.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

class DataProviderRestServiceNormalImpl : DataProviderServiceApi<List<ReviewDTO>> {

    private val rt = RestTemplate()

    @Value("\${application.data-provider-url.sample}")
    lateinit var dataSampleUrl: String

    @Value("\${application.data-provider-url.all}")
    lateinit var dataUrl: String

    override fun getSampleData(): List<ReviewDTO> {
        val response = rt.exchange(dataSampleUrl, HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<ReviewDTO>>() {})
        return response.body!!
    }

    override fun getAllData(): List<ReviewDTO> {
        val response = rt.exchange(dataUrl, HttpMethod.GET, null,
            object : ParameterizedTypeReference<List<ReviewDTO>>() {})
        return response.body!!
    }
}
