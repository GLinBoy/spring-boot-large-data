package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MentionedUsersDTO(

    @JsonProperty("_type") val type: String,
    val username: String,
    val id: Long,
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
