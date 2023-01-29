package com.glinboy.largedata.dataprocessor.service.processor

import java.util.*

abstract class AbstractProcess<T> {
    private lateinit var next: AbstractProcess<T>

    fun setNext(process: AbstractProcess<T>) {
        this.next = process
    }

    fun process(t: T) {
        this.job(t)
        Optional.ofNullable(next)
            .ifPresent { it.process(t) }
    }
    abstract fun job(t: T)
}
