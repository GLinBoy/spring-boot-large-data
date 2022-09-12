package com.glinboy.test.largedata.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MentionedUsers(

    @Id val id: Long,
    val type: String,
    val username: String,
    val displayname: String,
    val description: String,
    val rawDescription: String,
    val descriptionUrls: String,
    val verified: String,
    val created: String,
    val followersCount: String,
    val friendsCount: String,
    val statusesCount: String,
    val favouritesCount: String,
    val listedCount: String,
    val mediaCount: String,
    val location: String,
    val protected: String,
    val linkUrl: String,
    val linkTcourl: String,
    val profileImageUrl: String,
    val profileBannerUrl: String,
    val label: String,
    val url: String
)
