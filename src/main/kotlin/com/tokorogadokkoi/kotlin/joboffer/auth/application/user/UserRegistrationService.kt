package com.tokorogadokkoi.kotlin.joboffer.auth.application.user

import com.tokorogadokkoi.kotlin.joboffer.auth.application.exception.UserIsAlreadyRegistrationException
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.RoleCategory
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.RoleRepository
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.*
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user.UserRegistrationRequest
import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.user.UserRegistrationResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class UserRegistrationService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val userRoleRepository: UserRoleRepository
) {
    /**
     * システムのユーザ登録を行う
     * @param email 登録するメールアドレス
     * @param roleName 登録するロール名
     */
    @Transactional
    fun registrationUser(email: String, roleName: String): UserRegistrationResponse {
        val email = Email(email)

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
            ?: throw RuntimeException(
                "${roleName}はデータベースに登録されていません。"
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