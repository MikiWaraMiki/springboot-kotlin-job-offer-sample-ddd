package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.shared

data class InternalErrorResponse(
    val status: String = "500",
    val message: String
)