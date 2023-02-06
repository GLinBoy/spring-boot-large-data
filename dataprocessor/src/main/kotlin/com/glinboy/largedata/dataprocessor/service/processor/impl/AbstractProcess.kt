package com.glinboy.largedata.dataprocessor.service.processor.impl

import com.glinboy.largedata.dataprocessor.service.processor.Process

abstract class AbstractProcess<T> : Process<T> {
    private lateinit var next: Process<T>

    override fun setNext(process: Process<T>) {
        this.next = process
    }

    override fun process(data: T) {
        this.job(data)
        if(this::next.isInitialized) this.next.process(data)
    }
}
