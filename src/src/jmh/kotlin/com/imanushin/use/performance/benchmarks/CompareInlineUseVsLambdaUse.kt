package com.imanushin.use.performance.benchmarks

import com.imanushin.use.performance.executeKotlinUse
import com.imanushin.use.performance.executeNoInlineUse
import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 20)
@Measurement(iterations = 300)
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