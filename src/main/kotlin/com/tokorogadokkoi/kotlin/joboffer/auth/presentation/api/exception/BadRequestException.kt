package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.exception

open class BadRequestException(
    val statusCode: String = "400",
    val errCode: String? = null,
    val msg: String? = null
): RuntimeException(msg)