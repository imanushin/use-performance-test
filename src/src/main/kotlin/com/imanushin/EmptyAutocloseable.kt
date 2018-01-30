package com.imanushin

class EmptyAutocloseable : AutoCloseable {

    companion object {
        fun createNewCloseable() : AutoCloseable = EmptyAutocloseable()
    }

    override fun close() {
    }
}