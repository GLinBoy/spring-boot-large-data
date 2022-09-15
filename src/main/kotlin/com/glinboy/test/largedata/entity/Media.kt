package com.glinboy.test.largedata.entity

data class Media(
    val type: String?,
    val previewUrl: String?,
    val fullUrl: String?,
    val thumbnailUrl: String?,
    val variants: List<Variant>?,
    val duration: Double?,
    val views: Long?
)
