package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user

import com.tokorogadokkoi.kotlin.joboffer.auth.application.user.UserRegistrationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth/user")
class UserRegistrationController(
    private val userRegistrationService: UserRegistrationService
) {
    /**
     * 求人応募システムへの登録(/api/v1/auth/user/registration)
     */
    @PostMapping("/registration")
    fun registration(@RequestBody request: UserRegistrationRequest): UserRegistrationResponse {
        return  userRegistrationService.registrationUser(request)
    }

    
}