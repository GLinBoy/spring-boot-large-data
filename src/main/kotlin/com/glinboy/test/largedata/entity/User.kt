package com.glinboy.test.largedata.entity

import jakarta.persistence.*

@Entity
data class User(

    @Id val id: Long?,
    val type: String?,
    val username: String?,
    val displayname: String?,
    val description: String?,
    val rawDescription: String?,
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL], orphanRemoval = true)
    val descriptionUrls: List<DescriptionUrls>?,
    val verified: Boolean?,
    val created: String?,
    val followersCount: Int?,
    val friendsCount: Int?,
    val statusesCount: Int?,
    val favouritesCount: Int?,
    val listedCount: Int?,
    val mediaCount: Int?,
    val location: String?,
    val protected: Boolean?,
    val linkUrl: String?,
    val linkTcourl: String?,
    val profileImageUrl: String?,
    val profileBannerUrl: String?,
    val label: String?,
    val url: String?
)
