package com.sample.core.extensions


val String.Companion.empty: String get() = ""

fun String?.safeGet(): String = this ?: String.empty
