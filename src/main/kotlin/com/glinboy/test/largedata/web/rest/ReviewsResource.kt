package com.glinboy.test.largedata.web.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("reviews")
class ReviewsResource {

    @GetMapping("load/sample")
    fun loadSampleData(): ResponseEntity<Void> = ResponseEntity.ok().build()

    @GetMapping("load/all")
    fun loadAllData(): ResponseEntity<Void> = ResponseEntity.ok().build()
}
