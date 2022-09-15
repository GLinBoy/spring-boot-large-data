package com.glinboy.test.largedata.entity

import javax.persistence.*

@Entity
data class TweetNews(

    @Id val id: Long,
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
    val inReplyToUser: User,
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    val mentionedUsers: List<MentionedUsers>,
    @OneToOne
    @JoinColumn(name = "coordinates_id")
    val coordinates: Coordinates,
    @OneToOne
    @JoinColumn(name = "place_id")
    val place: Place,
    val hashtags: String,
    val cashtags: String
)
