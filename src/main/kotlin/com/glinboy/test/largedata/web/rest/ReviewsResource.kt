package com.glinboy.test.largedata.web.rest

import com.glinboy.test.largedata.service.ReviewsServiceApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("reviews")
class ReviewsResource(private val reviewsService: ReviewsServiceApi) {

    @GetMapping("load/sample")
    fun loadSampleData(): ResponseEntity<Void> {
        reviewsService.fetchSampleReviews()
        return ResponseEntity.ok().build()
    }

    @GetMapping("load/all")
    fun loadAllData(): ResponseEntity<Void> {
        reviewsService.fetchAllData()
        return ResponseEntity.ok().build()
    }
}
