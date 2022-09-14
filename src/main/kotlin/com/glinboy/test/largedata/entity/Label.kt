package com.glinboy.test.largedata.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Label(

    @Id val id: Long?,
    val type: String?,
    val description: String?,
    val url: String?,
    val badgeUrl: String?,
    val longDescription: String?
)
