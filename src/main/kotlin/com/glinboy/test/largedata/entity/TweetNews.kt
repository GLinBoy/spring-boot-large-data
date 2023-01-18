package com.glinboy.test.largedata.entity

import jakarta.persistence.*

@Entity
data class TweetNews(

    @Id val id: Long?,
    val type: String?,
    val url: String?,
    val date: String?,
    @Column(length = 512) val content: String?,
    @Column(length = 512) val renderedContent: String?,
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
        foreignKey = ForeignKey(name = "fk_user_tweet"))
    val user: User?,
    val replyCount: Int?,
    val retweetCount: Int?,
    val likeCount: Int?,
    val quoteCount: Int?,
    val conversationId: Long?,
    val lang: String?,
    val source: String?,
    val sourceUrl: String?,
    val sourceLabel: String?,
    @ElementCollection
    val outlinks: List<String>?,
    @ElementCollection
    val tcooutlinks: List<String>?,
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    val media: List<Media>?,
    val retweetedTweet: String?,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "quoted_tweet_id",
        foreignKey = ForeignKey(name = "fk_quoted_tweet"))
    val quotedTweet: TweetNews?,
    val inReplyToTweetId: Long?,
    @OneToOne
    @JoinColumn(name = "reply_to_user_id")
    val inReplyToUser: User?,
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    val mentionedUsers: List<User>?,
    @OneToOne
    @JoinColumn(name = "coordinates_id")
    val coordinates: Coordinates?,
    @OneToOne
    @JoinColumn(name = "place_id")
    val place: Place?,
    @ElementCollection
    val hashtags: List<String>?,
    val cashtags: String?
)
