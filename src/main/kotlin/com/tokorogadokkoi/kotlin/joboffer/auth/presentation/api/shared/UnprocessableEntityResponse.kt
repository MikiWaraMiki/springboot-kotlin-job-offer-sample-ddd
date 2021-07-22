package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.shared

data class UnprocessableEntityResponse(
    val status: String = "422",
    val message: String
)