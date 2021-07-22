package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.tokorogadokkoi.kotlin.joboffer.auth.application.exception.UserIsAlreadyRegistrationException
import com.tokorogadokkoi.kotlin.joboffer.auth.application.user.UserRegistrationService
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.UserID
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.handler.BadRequestExceptionHandler
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.handler.IllegalArgumentExceptionHandler
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.nio.charset.StandardCharsets

class UserRegistrationControllerTest {
    private val userRegistrationService = mock<UserRegistrationService>()
    private val userRegistrationController = UserRegistrationController(
        userRegistrationService
    )
    private lateinit var mockMvc: MockMvc
    private lateinit var mapper: ObjectMapper

    @BeforeEach
    fun setup() {
        mapper = ObjectMapper()
    }

    @Nested
    @DisplayName("/api/v1/user/registrationのテスト")
    inner class TestRegistrationUser() {
        @Test
        fun `登録が完了した場合正しいレスポンスを返すこと`() {
            mockMvc =  MockMvcBuilders.standaloneSetup(userRegistrationController).build()

            val email = "example@example.com"
            val userId  = UserID.generateUserId()

            val request = UserRegistrationRequest(
                email
            )

            val expectedResponse = UserRegistrationResponse(
                userId.toString(),
                email
            )
            val expected = mapper.registerKotlinModule().writeValueAsString(
                expectedResponse
            )

            whenever(userRegistrationService.registrationUser(email, "user")).thenReturn(
                expectedResponse
            )

            val resultResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/user/registration")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk).andReturn().response

            val result = resultResponse.getContentAsString(StandardCharsets.UTF_8)

            Assertions.assertThat(expected).isEqualTo(result)
        }

        @Test
        fun `メールアドレスが不正な値の場合は400レスポンスを返すこと`() {
            mockMvc =  MockMvcBuilders.standaloneSetup(userRegistrationController)
                .setControllerAdvice(IllegalArgumentExceptionHandler())
                .build()

            val email = "hgoehoge"
            val request = UserRegistrationRequest(
                email
            )

            whenever(userRegistrationService.registrationUser(email, "user")).thenThrow(
                IllegalArgumentException("メールアドレス以外が入力されています")
            )
            val resultResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/user/registration")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isUnprocessableEntity).andReturn().response
        }


        @Test
        fun `登録済みの場合は400レスポンスを返すこと`() {
            mockMvc =  MockMvcBuilders.standaloneSetup(userRegistrationController)
                .setControllerAdvice(BadRequestExceptionHandler())
                .build()

            val email = "sample@sample.com"
            val request = UserRegistrationRequest(
                email
            )

            whenever(userRegistrationService.registrationUser(email, "user")).thenThrow(
                UserIsAlreadyRegistrationException()
            )

            val resultResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/user/registration")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isBadRequest).andReturn().response
        }
    }

    @Nested
    @DisplayName("/api/v1/auth/client/registrationのテスト")
    inner class TestRegistrationClient() {
        @Test
        fun `登録が完了した場合正しいレスポンスを返すこと`() {
            mockMvc =  MockMvcBuilders.standaloneSetup(userRegistrationController).build()

            val email = "example@example.com"
            val userId  = UserID.generateUserId()

            val request = UserRegistrationRequest(
                email
            )

            val expectedResponse = UserRegistrationResponse(
                userId.toString(),
                email
            )
            val expected = mapper.registerKotlinModule().writeValueAsString(
                expectedResponse
            )

            whenever(userRegistrationService.registrationUser(email, "client")).thenReturn(
                expectedResponse
            )

            val resultResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/client/registration")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk).andReturn().response

            val result = resultResponse.getContentAsString(StandardCharsets.UTF_8)

            Assertions.assertThat(expected).isEqualTo(result)
        }

        @Test
        fun `メールアドレスが不正な値の場合は400レスポンスを返すこと`() {
            mockMvc =  MockMvcBuilders.standaloneSetup(userRegistrationController)
                .setControllerAdvice(IllegalArgumentExceptionHandler())
                .build()

            val email = "hgoehoge"
            val request = UserRegistrationRequest(
                email
            )

            whenever(userRegistrationService.registrationUser(email, "client")).thenThrow(
                IllegalArgumentException("メールアドレス以外が入力されています")
            )
            val resultResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/client/registration")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isUnprocessableEntity).andReturn().response
        }


        @Test
        fun `登録済みの場合は400レスポンスを返すこと`() {
            mockMvc =  MockMvcBuilders.standaloneSetup(userRegistrationController)
                .setControllerAdvice(BadRequestExceptionHandler())
                .build()

            val email = "sample@sample.com"
            val request = UserRegistrationRequest(
                email
            )

            whenever(userRegistrationService.registrationUser(email, "client")).thenThrow(
                UserIsAlreadyRegistrationException()
            )

            val resultResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/auth/client/registration")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isBadRequest).andReturn().response
        }
    }


}