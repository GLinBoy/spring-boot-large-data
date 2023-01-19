package com.glinboy.test.largedata

import com.glinboy.test.largedata.client.DataProviderService
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class RunMe(val dataProviderService: DataProviderService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @EventListener(ApplicationReadyEvent::class)
    fun run() {
        logger.info("Let's do some logic!")
    }
}
