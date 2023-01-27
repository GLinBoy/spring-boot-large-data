package com.glinboy.largedata.dataprocessor.client

import com.glinboy.largedata.shared.dto.ReviewDTO

interface DataProviderServiceApi {
    fun getSampleData(): List<ReviewDTO>
    fun getAllData(): List<ReviewDTO>
}
