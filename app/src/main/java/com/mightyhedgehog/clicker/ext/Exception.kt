package com.mightyhedgehog.clicker.ext

fun wrongStateError(message: String): Nothing = error("Wrong state: $message")

fun wrongEventError(message: String): Nothing = error("Wrong event: $message")
