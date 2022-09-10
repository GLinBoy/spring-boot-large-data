package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TweetNewsResponseDTO(

    @JsonProperty("_type") val type: String,
    val url: String,
    val date: String,
    val content: String,
    val renderedContent: String,
    val id: Int,
    val user: UserDTO,
    val replyCount: Int,
    val retweetCount: Int,
    val likeCount: Int,
    val quoteCount: Int,
    val conversationId: Int,
    val lang: String,
    val source: String,
    val sourceUrl: String,
    val sourceLabel: String,
    val outlinks: String,
    val tcooutlinks: String,
    val media: String,
    val retweetedTweet: String,
    val quotedTweet: String,
    val inReplyToTweetId: Int,
    val inReplyToUser: InReplyToUserDTO,
    val mentionedUsers: List<MentionedUsersDTO>,
    val coordinates: CoordinatesDTO,
    val place: PlaceDTO,
    val hashtags: String,
    val cashtags: String
)