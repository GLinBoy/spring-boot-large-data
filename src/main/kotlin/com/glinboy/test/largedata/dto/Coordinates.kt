package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class Coordinates(

    @JsonProperty("_type") val type: String,
    val longitude: Double,
    val latitude: Double
)
