package com.glinboy.test.largedata.entity

import jakarta.persistence.*

@Entity
data class Variant(
    @Id val id: Long,
    val type: String?,
    val contentType: String?,
    val url: String?,
    val bitrate: Long?,
    @ManyToOne
    @JoinColumn(name = "MEDIA_ID", nullable = false,
        foreignKey = ForeignKey(name = "FK_MEDIA_VARIANT"))
    val media: Media?
)
