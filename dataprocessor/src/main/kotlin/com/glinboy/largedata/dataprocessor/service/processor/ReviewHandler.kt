package com.glinboy.largedata.dataprocessor.service.processor

import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.stereotype.Component

@Component
class ReviewHandler(
    private val deleteProcess: DeleteProcess,
    private val saveProcess: SaveProcess,
    private val publishProcess: PublishProcess
) {
    fun getReviewHandlerChain(): AbstractProcess<List<ReviewDTO>> {
        deleteProcess.setNext(saveProcess)
        saveProcess.setNext(publishProcess)
        return deleteProcess
    }
}
