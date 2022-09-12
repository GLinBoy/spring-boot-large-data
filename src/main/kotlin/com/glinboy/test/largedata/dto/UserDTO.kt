package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDTO(

    @JsonProperty("_type") val type: String,
    val username: String,
    val id: Long,
    val displayname: String,
    val description: String,
    val rawDescription: String,
    val descriptionUrls: String,
    val verified: Boolean,
    val created: String,
    val followersCount: Int,
    val friendsCount: Int,
    val statusesCount: Int,
    val favouritesCount: Int,
    val listedCount: Int,
    val mediaCount: Int,
    val location: String,
    val protected: Boolean,
    val linkUrl: String,
    val linkTcourl: String,
    val profileImageUrl: String,
    val profileBannerUrl: String,
    val label: String,
    val url: String
)
