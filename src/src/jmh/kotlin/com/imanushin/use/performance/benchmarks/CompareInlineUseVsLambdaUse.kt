package com.imanushin.use.performance.benchmarks

import com.imanushin.use.performance.useNoInline
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

@BenchmarkMode(Mode.All)
@Warmup
@Measurement
open class CompareInlineUseVsLambdaUse {

    @Benchmark
    fun inlineUse(blackhole: Blackhole) {
        NoopAutoCloseable(blackhole).use {
            blackhole.consume(1)
        }
    }

    @Benchmark
    fun lambdaUse(blackhole: Blackhole) {
        NoopAutoCloseable(blackhole).useNoInline {
            blackhole.consume(1)
        }
    }
}