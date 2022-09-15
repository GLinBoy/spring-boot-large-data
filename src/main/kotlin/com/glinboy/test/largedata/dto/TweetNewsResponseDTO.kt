package com.glinboy.test.largedata.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TweetNewsResponseDTO(
    val id: Long?,
    @JsonProperty("_type") val type: String?,
    val url: String?,
    val date: String?,
    val content: String?,
    val renderedContent: String?,
    val user: UserDTO?,
    val replyCount: Int?,
    val retweetCount: Int?,
    val likeCount: Int?,
    val quoteCount: Int?,
    val conversationId: Long?,
    val lang: String?,
    val source: String?,
    val sourceUrl: String?,
    val sourceLabel: String?,
    val outlinks: List<String>?,
    val tcooutlinks: List<String>?,
    val media: List<MediaDTO>?,
    val retweetedTweet: String?,
    val quotedTweet: TweetNewsResponseDTO?,
    val inReplyToTweetId: Long?,
    val inReplyToUser: UserDTO?,
    val mentionedUsers: List<UserDTO>?,
    val coordinates: CoordinatesDTO?,
    val place: PlaceDTO?,
    val hashtags: List<String>?,
    val cashtags: String?
)
