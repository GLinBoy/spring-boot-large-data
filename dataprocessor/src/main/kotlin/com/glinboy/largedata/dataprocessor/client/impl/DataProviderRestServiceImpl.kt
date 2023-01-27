package com.glinboy.largedata.dataprocessor.client.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DataProviderRestServiceImpl: DataProviderServiceApi {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun getSampleData(): List<ReviewDTO> {
        TODO("Not yet implemented")
    }

    override fun getAllData(): List<ReviewDTO> {
        TODO("Not yet implemented")
    }
}
