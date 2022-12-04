package com.glinboy.test.largedata.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Coordinates(

    @Id val id: Long?,
    val type: String?,
    val longitude: Double?,
    val latitude: Double?
)
