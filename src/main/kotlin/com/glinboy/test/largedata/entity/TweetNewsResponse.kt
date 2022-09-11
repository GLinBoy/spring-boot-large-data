package com.glinboy.test.largedata.entity

import javax.persistence.*

@Entity
data class TweetNewsResponse(

    @Id val id: Int,
    val type: String,
    val url: String,
    val date: String,
    val content: String,
    val renderedContent: String,
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
        foreignKey = ForeignKey(name = "fk_user_tweet"))
    val user: User,
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
    @OneToOne
    @JoinColumn(name = "reply_to_user_id")
    val inReplyToUser: InReplyToUser,
//    val mentionedUsers: List<MentionedUsers>,
//    val coordinates: Coordinates,
//    val place: Place,
    val hashtags: String,
    val cashtags: String
)
