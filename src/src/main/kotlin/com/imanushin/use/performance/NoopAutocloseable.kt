package com.imanushin.use.performance

object NoopAutocloseable : AutoCloseable {

    override fun close() {
    }
}