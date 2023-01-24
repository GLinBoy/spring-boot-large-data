package com.glinboy.largedata.dataprovider.web.rest

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data")
class DataResource {

    val mapper = jacksonObjectMapper()

    @GetMapping("sample")
    fun returnSampleData(): ResponseEntity<List<ReviewDTO>> = ResponseEntity.ok(
        mapper.readValue(
        this::class.java
            .getResource("/data/IMDB_reviews.sample.json")?.readText() ?: "[]"
        )
    )

    @GetMapping("all")
    fun returnAllData(): ResponseEntity<List<ReviewDTO>> = ResponseEntity.ok(
        mapper.readValue(
        this::class.java
            .getResource("/data/IMDB_reviews.sample.json")?.readText() ?: "[]"
        )
    )

}
