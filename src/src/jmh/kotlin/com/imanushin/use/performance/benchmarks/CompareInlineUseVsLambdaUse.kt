package com.imanushin.use.performance.benchmarks

import com.imanushin.use.performance.executeKotlinUse
import com.imanushin.use.performance.executeNoInlineUse
import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 100)
open class CompareInlineUseVsLambdaUse {

    @Benchmark
    fun inlineUse() {
        executeKotlinUse()
    }

    @Benchmark
    fun lambdaUse() {
        executeNoInlineUse()
    }
}