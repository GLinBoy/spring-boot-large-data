package com.glinboy.largedata.dataprocessor.client.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class DataProviderRestServiceImpl: DataProviderServiceApi {

    private val log = LoggerFactory.getLogger(javaClass)
    private val rt = RestTemplate()

    @Value("\${application.data-provider-url.sample}")
    lateinit var dataSampleUrl: String

    @Value("\${application.data-provider-url.all}")
    lateinit var dataUrl: String

    override fun getSampleData(): List<ReviewDTO> {
        log.info(dataSampleUrl)
        return listOf()
    }

    override fun getAllData(): List<ReviewDTO> {
        log.info(dataUrl)
        return listOf()
    }
}
