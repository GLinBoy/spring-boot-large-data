package com.glinboy.largedata.dataprocessor.client

interface DataProviderServiceApi<T> {
    fun getSampleData(): T
    fun getAllData(): T
}
