package com.glinboy.test.largedata.client.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.glinboy.test.largedata.client.DataProviderService
import org.springframework.stereotype.Service

@Service
class FileDataProviderServiceImpl : DataProviderService {

    val mapper = jacksonObjectMapper()

    override fun invokeApiProvider(): List<Any> = listOf()
}
