package com.imanushin.use.performance.benchmarks

import org.openjdk.jmh.infra.Blackhole

class NoopAutoCloseable(private val blackhole: Blackhole) : AutoCloseable {

    override fun close() {
        blackhole.consume(0)
    }
}