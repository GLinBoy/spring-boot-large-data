package com.glinboy.test.largedata

import com.glinboy.test.largedata.client.DataProviderService
import com.glinboy.test.largedata.entity.TweetNews
import com.glinboy.test.largedata.repository.TweetNewsRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class RunMe(val dataProviderService: DataProviderService, val tweetNewsRepository: TweetNewsRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @EventListener(ApplicationReadyEvent::class)
    fun run() {
        logger.info("Let's do some logic!")
        val response = dataProviderService.invokeApiProvider()
        logger.info("---> Response size: {}", response.size)
        val news: List<TweetNews> = response.stream().map {
            TweetNews(
                it?.id,
                it?.type,
                it?.url,
                it?.date,
                it?.content,
                it?.renderedContent,
                null, // User
                it?.replyCount,
                it?.retweetCount,
                it?.likeCount,
                it?.quoteCount,
                it?.conversationId,
                it?.lang,
                it?.source,
                it?.sourceUrl,
                it?.sourceLabel,
                it?.outlinks,
                it?.tcooutlinks,
                null, // media,
                it?.retweetedTweet,
                null, // quotedTweet
                it?.inReplyToTweetId,
                null, // inReplyToUser
                null, // mentionedUsers
                null, // coordinates
                null, // place
                it?.hashtags,
                it?.cashtags
            )
        }
            .collect(Collectors.toList())
//        tweetNewsRepository.saveAll(news)
    }
}
