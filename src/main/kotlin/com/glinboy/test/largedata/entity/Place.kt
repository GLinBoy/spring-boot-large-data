package com.glinboy.test.largedata.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Place(

    @Id val id: Long,
    val type: String,
    val fullName: String,
    val name: String,
    val placeType: String,
    val country: String,
    val countryCode: String
)
