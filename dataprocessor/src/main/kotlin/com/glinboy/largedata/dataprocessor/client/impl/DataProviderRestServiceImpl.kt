package com.glinboy.largedata.dataprocessor.client.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderService
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.stereotype.Service

@Service
class DataProviderRestServiceImpl: DataProviderService {
    override fun invokeApiProvider(): List<ReviewDTO> {
        TODO("Not yet implemented")
    }
}
