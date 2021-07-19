package com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user

import com.tokorogadokkoi.kotlin.joboffer.auth.application.user.UserRegistrationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class UserRegistrationController(
    private val userRegistrationService: UserRegistrationService
) {
    /**
     * 求人応募システムへの登録(/api/v1/auth/user/registration)
     */
    @PostMapping("/user/registration")
    fun registration(@RequestBody request: UserRegistrationRequest): UserRegistrationResponse {
        return  userRegistrationService.registrationUser(request.email, "user")
    }

    /**
     * 求人募集システムへの登録(/api/v1/auth/client/registration)
     */
    @PostMapping("/client/registration")
    fun registrationClient(@RequestBody request: UserRegistrationRequest): UserRegistrationResponse {
        return userRegistrationService.registrationUser(request.email, "client")
    }


}