package com.glinboy.largedata.dataprocessor.service.processor

interface ReviewHandler<T : Process<E>, E> {
    fun getReviewHandlerChain(): T
}
