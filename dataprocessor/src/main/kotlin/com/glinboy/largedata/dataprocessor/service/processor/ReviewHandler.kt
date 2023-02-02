package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.stereotype.Component

@Component
class ReviewHandler(
    private val saveProcess: SaveProcess,
    private val publishProcess: PublishProcess
) {
    fun getReviewHandlerChain(): AbstractProcess<ReviewDTO> {
        saveProcess.setNext(publishProcess)
        return saveProcess
    }
}
