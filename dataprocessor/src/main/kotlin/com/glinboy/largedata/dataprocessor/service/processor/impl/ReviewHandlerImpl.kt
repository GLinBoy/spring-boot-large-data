package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.service.processor.Process
import com.glinboy.largedata.dataprocessor.service.processor.PublishProcess
import com.glinboy.largedata.dataprocessor.service.processor.ReviewHandler
import com.glinboy.largedata.dataprocessor.service.processor.SaveProcess
import com.glinboy.largedata.shared.dto.ReviewDTO

class ReviewHandlerImpl(
    private val saveProcess: SaveProcess<ReviewDTO>,
    private val publishProcess: PublishProcess<ReviewDTO>
) : ReviewHandler<Process<ReviewDTO>, ReviewDTO> {
    override fun getReviewHandlerChain(): Process<ReviewDTO> {
        saveProcess.setNext(publishProcess)
        return saveProcess
    }
}
