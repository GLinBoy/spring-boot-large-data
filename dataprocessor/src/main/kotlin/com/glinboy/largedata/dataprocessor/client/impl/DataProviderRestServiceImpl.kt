package com.glinboy.largedata.dataprocessor.client.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.stereotype.Service

@Service
class DataProviderRestServiceImpl: DataProviderServiceApi {
    override fun getSampleData(): List<ReviewDTO> {
        TODO("Not yet implemented")
    }

    override fun getAllData(): List<ReviewDTO> {
        TODO("Not yet implemented")
    }
}
