package com.tokorogadokkoi.kotlin.joboffer.auth.application.exception

/**
 *
 */
class InternalException(
    val statusCode: String = "500",
    val msg: String? = null
): RuntimeException(msg)