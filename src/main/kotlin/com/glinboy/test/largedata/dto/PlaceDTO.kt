package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PlaceDTO(

    @JsonProperty("_type") val type: String?,
    val fullName: String?,
    val name: String?,
    @JsonProperty("type") val placeType: String?,
    val country: String?,
    val countryCode: String?
)
