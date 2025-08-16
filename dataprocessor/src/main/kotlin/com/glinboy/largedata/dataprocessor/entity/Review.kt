package com.glinboy.largedata.dataprocessor.entity

import jakarta.persistence.*

@Entity
data class Review(
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long? = null,
	val reviewDate: String? = null,
	val movieId: String? = null,
	val userId: String? = null,
	val isSpoiler: Boolean? = null,
	@Column(columnDefinition = "TEXT") val reviewText: String? = null,
	val rating: String? = null,
	@Column(columnDefinition = "TEXT") val reviewSummary: String? = null
)
