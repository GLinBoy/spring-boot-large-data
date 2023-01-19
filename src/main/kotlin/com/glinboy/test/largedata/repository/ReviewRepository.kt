package com.glinboy.test.largedata.repository

import com.glinboy.test.largedata.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
}
