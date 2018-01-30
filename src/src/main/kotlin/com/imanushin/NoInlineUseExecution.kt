package com.imanushin

import java.io.Closeable

fun executeNoInlineUse() {
    Closeable {}.use {}
    (0..10).forEach {
        executeUseMultiple(Math.pow(2.0, it.toDouble()).toInt())
    }
}

@Suppress("NOTHING_TO_INLINE")
private inline fun executeUseMultiple(executeUseTimes: Int) {
    (0..executeUseTimes).forEach {
        executeUse()
    }
}

@Suppress("NOTHING_TO_INLINE")
private inline fun executeUse() {
    EmptyAutocloseable.createNewCloseable().useNoInline {
        /*do nothing */
    }
}