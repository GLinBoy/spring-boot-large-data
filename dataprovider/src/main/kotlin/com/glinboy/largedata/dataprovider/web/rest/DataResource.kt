package com.glinboy.largedata.dataprovider.web.rest

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data")
class DataResource {

    val mapper = jacksonObjectMapper()

    @Value("\${application.file-path.sample}")
    lateinit var sampleFileName: String

    @Value("\${application.file-path.main}")
    lateinit var mainFileName: String

    @GetMapping("sample")
    fun returnSampleData(): ResponseEntity<List<ReviewDTO>> = ResponseEntity.ok(
        mapper.readValue(
        this::class.java
            .getResource(sampleFileName)?.readText() ?: "[]"
        )
    )

    @GetMapping("all")
    fun returnAllData(): ResponseEntity<List<ReviewDTO>> = ResponseEntity.ok(
        mapper.readValue(
        this::class.java
            .getResource(mainFileName)?.readText() ?: "[]"
        )
    )

}
