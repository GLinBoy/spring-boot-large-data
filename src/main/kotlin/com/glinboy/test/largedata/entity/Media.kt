package com.glinboy.test.largedata.entity

import javax.persistence.*

@Entity
data class Media(
    @Id val id: Long,
    val type: String?,
    val previewUrl: String?,
    val fullUrl: String?,
    val thumbnailUrl: String?,
    @OneToMany(mappedBy = "media", fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL], orphanRemoval = true)
    val variants: List<Variant>?,
    val duration: Double?,
    val views: Long?
)
