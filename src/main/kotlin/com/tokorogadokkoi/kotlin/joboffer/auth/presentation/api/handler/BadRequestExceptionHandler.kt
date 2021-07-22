package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.handler

import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.exception.BadRequestException
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.shared.BadRequestResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class BadRequestExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(
        exception: BadRequestException,
        request: WebRequest
    ): ResponseEntity<Any> {
        val responseBody = BadRequestResponse(
            errCode = exception.errCode ?: "",
            message = exception.message ?: ""
        )

        return super.handleExceptionInternal(
            exception,
            responseBody,
            HttpHeaders(),
            HttpStatus.BAD_REQUEST,
            request
        )
    }
}