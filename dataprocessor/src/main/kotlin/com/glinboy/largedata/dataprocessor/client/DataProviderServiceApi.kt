package com.glinboy.largedata.dataprocessor.client

import java.io.File

interface DataProviderServiceApi {
    fun getSampleData(): File
    fun getAllData(): File
}
