package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class LabelDTO(
    @JsonProperty("_type") val type: String?,
    val description: String?,
    val url: String?,
    val badgeUrl: String?,
    val longDescription: String?
)
