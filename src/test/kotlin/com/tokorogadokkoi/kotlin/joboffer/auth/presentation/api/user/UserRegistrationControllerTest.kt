package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.tokorogadokkoi.kotlin.joboffer.auth.application.user.UserRegistrationService
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.UserID
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
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
        mockMvc =  MockMvcBuilders.standaloneSetup(userRegistrationController).build()
        mapper = ObjectMapper()
    }

    @Test
    fun `正しいレスポンスを返すこと`() {
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

        whenever(userRegistrationService.registrationUser(request)).thenReturn(
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
}