package com.glinboy.largedata.dataprocessor.client.impl

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.util.StreamUtils
import org.springframework.web.client.RestTemplate
import java.io.File
import java.io.FileOutputStream

class DataProviderRestServiceImpl : DataProviderServiceApi<File> {

    private val rt = RestTemplate()

    @Value("\${application.data-provider-url.sample}")
    lateinit var dataSampleUrl: String

    @Value("\${application.data-provider-url.all}")
    lateinit var dataUrl: String

    override fun getSampleData(): File {
        return getResultAsFile(dataSampleUrl)
    }

    override fun getAllData(): File {
        return getResultAsFile(dataUrl)
    }

    private fun getResultAsFile(url: String): File = rt.execute(
        url,
        HttpMethod.GET,
        null,
        { clientHttpResponse ->
            val f: File = File.createTempFile("download_", "_tmp")
            StreamUtils.copy(clientHttpResponse.body, FileOutputStream(f))
            f
        })!!
}
