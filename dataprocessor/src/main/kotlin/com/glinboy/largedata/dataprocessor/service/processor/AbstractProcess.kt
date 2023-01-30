package com.glinboy.largedata.dataprocessor.service.processor

abstract class AbstractProcess<T> {
    private lateinit var next: AbstractProcess<T>

    fun setNext(process: AbstractProcess<T>) {
        this.next = process
    }

    fun process(t: T) {
        this.job(t)
        if(this::next.isInitialized) this.next.process(t)
    }
    abstract fun job(t: T)
}
