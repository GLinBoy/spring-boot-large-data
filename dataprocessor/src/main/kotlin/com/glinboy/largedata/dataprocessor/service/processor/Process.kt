package com.glinboy.largedata.dataprocessor.service.processor

interface Process<T> {
    fun setNext(process: Process<T>)
    fun process(data: T)
    fun job(data: T)
}
