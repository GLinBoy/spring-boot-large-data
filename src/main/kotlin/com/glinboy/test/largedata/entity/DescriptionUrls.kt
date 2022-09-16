package com.glinboy.test.largedata.entity

import javax.persistence.*

@Entity
data class DescriptionUrls(

    @Id val id: Long?,
    val text: String?,
    val url: String?,
    val tcourl: String?,
    @ElementCollection
    val indices: List<Long>?,
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false,
        foreignKey = ForeignKey(name = "FK_USER_DESC_URL"))
    val user: User
)
