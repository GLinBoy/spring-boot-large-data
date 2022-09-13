package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class VariantDTO(
    @JsonProperty("_type") val type: String?,
    val contentType: String?,
    val url: String?,
    val bitrate: Long?
)
