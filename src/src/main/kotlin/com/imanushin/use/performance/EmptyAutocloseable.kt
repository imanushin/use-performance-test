package com.imanushin.use.performance

class EmptyAutocloseable : AutoCloseable {

    companion object {
        fun createNewCloseable() : AutoCloseable = EmptyAutocloseable()
    }

    override fun close() {
    }
}