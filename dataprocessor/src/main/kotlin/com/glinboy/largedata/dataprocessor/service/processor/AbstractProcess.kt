package com.glinboy.largedata.dataprocessor.service.processor

abstract class AbstractProcess<T> {
    private lateinit var next: AbstractProcess<T>

    fun setNext(process: AbstractProcess<T>) {
        this.next = process
    }

    fun process(data: T) {
        this.job(data)
        if(this::next.isInitialized) this.next.process(data)
    }
    abstract fun job(data: T)
}
