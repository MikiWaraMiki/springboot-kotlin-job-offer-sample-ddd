package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.handler

import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.exception.BadRequestException
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.shared.UnprocessableEntityResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import kotlin.IllegalArgumentException

@RestControllerAdvice
class IllegalArgumentExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(
        exception: IllegalArgumentException,
        request: WebRequest
    ): ResponseEntity<Any> {
        val response = UnprocessableEntityResponse(
            message = exception.message ?: ""
        )

        return super.handleExceptionInternal(
            exception,
            response,
            HttpHeaders(),
            HttpStatus.UNPROCESSABLE_ENTITY,
            request
        )
    }
}