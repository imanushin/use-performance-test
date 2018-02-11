package com.imanushin.use.performance

fun executeNoInlineUse() {
    NoopAutocloseable.useNoInline {
        /*do nothing */
    }
}