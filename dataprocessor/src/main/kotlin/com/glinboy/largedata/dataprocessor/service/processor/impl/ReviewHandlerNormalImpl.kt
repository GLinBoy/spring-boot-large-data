package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.service.processor.*
import com.glinboy.largedata.shared.dto.ReviewDTO

class ReviewHandlerNormalImpl(
    private val deleteProcess: DeleteProcess<List<ReviewDTO>>,
    private val saveProcess: SaveProcess<List<ReviewDTO>>,
    private val publishProcess: PublishProcess<List<ReviewDTO>>
) : ReviewHandler<Process<List<ReviewDTO>>, List<ReviewDTO>> {
    override fun getReviewHandlerChain(): Process<List<ReviewDTO>> {
        deleteProcess.setNext(saveProcess)
        saveProcess.setNext(publishProcess)
        return deleteProcess
    }
}
