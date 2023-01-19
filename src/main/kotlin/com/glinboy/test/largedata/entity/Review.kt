package com.glinboy.test.largedata.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Review(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val reviewDate: String? = null,
    val movieId: String? = null,
    val userId: String? = null,
    val isSpoiler: Boolean? = null,
    @Column(columnDefinition="TEXT") val reviewText: String? = null,
    val rating: String? = null,
    val reviewSummary: String? = null
)
