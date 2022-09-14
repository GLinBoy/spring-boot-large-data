package com.glinboy.test.largedata.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Label(
    val type: String?,
    val description: String?,
    val url: String?,
    val badgeUrl: String?,
    val longDescription: String?
)
