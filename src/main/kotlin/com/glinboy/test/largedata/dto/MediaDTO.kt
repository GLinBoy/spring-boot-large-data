package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MediaDTO (
    @JsonProperty("_type") val type: String?,
    val previewUrl: String?,
    val fullUrl: String?,
    val thumbnailUrl: String?,
    val variants: List<VariantDTO>?,
    val duration: Double?,
    val views: Long?
)
