package com.glinboy.test.largedata.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Variant(
    @Id val id: Long,
    val type: String?,
    val contentType: String?,
    val url: String?,
    val bitrate: Long?
)
