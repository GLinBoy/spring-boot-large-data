package com.glinboy.largedata.dataprocessor.repository

import com.glinboy.largedata.dataprocessor.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
}
