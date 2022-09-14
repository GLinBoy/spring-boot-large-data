package com.glinboy.test.largedata.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Coordinates(

    @Id val id: Long?,
    val type: String?,
    val longitude: Double?,
    val latitude: Double?
)
