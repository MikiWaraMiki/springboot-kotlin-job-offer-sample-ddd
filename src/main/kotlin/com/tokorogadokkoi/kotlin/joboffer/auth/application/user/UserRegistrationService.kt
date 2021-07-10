package com.tokorogadokkoi.kotlin.joboffer.auth.application.user

import com.tokorogadokkoi.kotlin.joboffer.auth.application.exception.InternalException
import com.tokorogadokkoi.kotlin.joboffer.auth.application.exception.UserIsAlreadyRegistrationException
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.RoleCategory
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.RoleRepository
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.*
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user.UserRegistrationRequest
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user.UserRegistrationResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserRegistrationService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val userRoleRepository: UserRoleRepository
) {
    /**
     * 求人応募システムのユーザ登録を行う
     * @param request コントローラに送信されたリクエストパラメータ
     * @param response 登録処理が成功した際のレスポンスボディ
     */
    @Transactional
    fun registrationUser(request: UserRegistrationRequest): UserRegistrationResponse {
        val email = Email(request.email)

        if (userRepository.findByEmail(email) != null) {
            throw UserIsAlreadyRegistrationException()
        }
        val userId = UserID.generateUserId()
        val userHavingRoleList = UserHavingRoleList()
        val user = User(
            userId,
            email,
            userHavingRoleList
        )
        val userRole = roleRepository.findByName(RoleCategory.USER.roleName)
            ?: throw InternalException(
                "500",
                "求人応募システムユーザ用のロールデータが登録されていません。"
            )
        user.addRole(userRole)

        userRepository.insertUser(user)
        userRoleRepository.insertUserRole(user, userRole)

        return UserRegistrationResponse(
            user.userId.toString(),
            user.email.toString()
        )
    }
}