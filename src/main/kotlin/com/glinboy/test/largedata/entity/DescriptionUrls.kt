package com.glinboy.test.largedata.entity

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class DescriptionUrls(

    @Id val id: Long?,
    val text: String?,
    val url: String?,
    val tcourl: String?,
    @ElementCollection
    val indices: List<Long>?
)
