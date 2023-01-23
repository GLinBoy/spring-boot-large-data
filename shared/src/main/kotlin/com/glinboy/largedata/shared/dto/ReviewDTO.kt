package com.glinboy.largedata.shared.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ReviewDTO(
    val reviewDate: String? = null,
    val movieId: String? = null,
    val userId: String? = null,
    val isSpoiler: Boolean? = null,
    val reviewText: String? = null,
    val rating: String? = null,
    val reviewSummary: String? = null
)
