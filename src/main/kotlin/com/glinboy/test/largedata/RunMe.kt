package com.glinboy.test.largedata

import com.glinboy.test.largedata.client.DataProviderService
import com.glinboy.test.largedata.entity.TweetNews
import com.glinboy.test.largedata.repository.TweetNewsRepository
import org.modelmapper.ModelMapper
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class RunMe(val dataProviderService: DataProviderService, val tweetNewsRepository: TweetNewsRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val mapper = ModelMapper()

    @EventListener(ApplicationReadyEvent::class)
    fun run() {
        logger.info("Let's do some logic!")
        val response = dataProviderService.invokeApiProvider()
        logger.info("---> Response size: {}", response.size)
        val dto = response[0]
        logger.info("---> DTO: {}", dto)
        val news = mapper.map(dto, TweetNews::class.java)
        logger.info("---> Entity: {}", news)
//        val news = response.stream().map {
//            logger.info("---> $it")
//            mapper.map(it, TweetNews::class.java)
//        }
//            .collect(Collectors.toList())
//        tweetNewsRepository.saveAll(news)
    }
}
