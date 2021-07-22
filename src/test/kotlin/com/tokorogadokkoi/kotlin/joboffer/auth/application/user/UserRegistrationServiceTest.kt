package com.tokorogadokkoi.kotlin.joboffer.auth.application.user

import com.tokorogadokkoi.kotlin.joboffer.auth.application.exception.UserIsAlreadyRegistrationException
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.Role
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.RoleCategory
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.RoleRepository
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.IllegalArgumentException

internal class UserRegistrationServiceTest {
    private val userRepository = mock<UserRepository>()
    private val roleRepository = mock<RoleRepository>()
    private val userRoleRepository = mock<UserRoleRepository>()

    private val userRegistrationService = UserRegistrationService(
        userRepository,
        roleRepository,
        userRoleRepository
    )

    @Nested
    @DisplayName("登録済みではないかつメールアドレスが正しい場合")
    inner class TestSuccessCase() {
        @Test
        fun `ユーザ登録が完了し、登録後のデータが返却されること`() {
            val email = Email("example@example.com")
            val role = Role(
                id = 1,
                _name = RoleCategory.CLIENT.name
            )
            whenever(userRepository.findByEmail(any() as Email)).thenReturn(null)
            whenever(roleRepository.findByName(any() as String)).thenReturn(role)


            val response = userRegistrationService.registrationUser(email.toString(), "user")

            Assertions.assertThat(response.email).isEqualTo(email.toString())
        }
    }

    @Nested
    @DisplayName("メールアドレスの形式が不正な場合")
    inner class InvalidEmailTest() {
        fun `エラーが発生すること`() {
            val role = Role(
                id = 1,
                _name = RoleCategory.CLIENT.name
            )
            whenever(userRepository.findByEmail(any() as Email)).thenReturn(null)
            whenever(roleRepository.findByName(any() as String)).thenReturn(role)


            val exception = assertThrows<IllegalArgumentException> {
                userRegistrationService.registrationUser("hogehoge", "user")
            }

            Assertions.assertThat(exception.message).isEqualTo("メールアドレス以外が入力されています")
        }
    }

    @Nested
    @DisplayName("メールアドレスがから文字の場合")
    inner class EmptyEmailTest() {
        fun `エラーが発生すること`() {
            val role = Role(
                id = 1,
                _name = RoleCategory.CLIENT.name
            )
            whenever(userRepository.findByEmail(any() as Email)).thenReturn(null)
            whenever(roleRepository.findByName(any() as String)).thenReturn(role)


            val exception = assertThrows<IllegalArgumentException> {
                userRegistrationService.registrationUser("", "user")
            }

            Assertions.assertThat(exception.message).isEqualTo("メールアドレスの入力は必須です")
        }
    }

    @Nested
    @DisplayName("リクエストしたロール名が存在しない場合")
    inner class RoleIsNotExistTest() {
        fun `エラーが発生すること`() {
            val email = "example@example.com"
            whenever(userRepository.findByEmail(any () as Email)).thenReturn(null)
            whenever(roleRepository.findByName(any() as String)).thenReturn(null)

            val exception = assertThrows<RuntimeException> {
                userRegistrationService.registrationUser(email, "not_found")
            }

            Assertions.assertThat(exception.message).isEqualTo("not_foundはデータベースに登録されていません")
        }
    }

    @Nested
    @DisplayName("すでに登録済みの場合")
    inner class DuplicationTest() {
        fun `エラーが発生すること`() {
            val email = Email("example@example.com")
            val user = User(
                UserID.generateUserId(),
                email,
                UserHavingRoleList()
            )
            val role = Role(
                id = 1,
                _name = RoleCategory.CLIENT.name
            )
            whenever(userRepository.findByEmail(any() as Email)).thenReturn(user)
            whenever(roleRepository.findByName(any() as String)).thenReturn(role)

            val exception = assertThrows<UserIsAlreadyRegistrationException> {
                userRegistrationService.registrationUser(email.toString(), "user")
            }

            Assertions.assertThat(exception.statusCode).isEqualTo("400")
            Assertions.assertThat(exception.msg).isEqualTo("メールアドレスはすでに登録済みです")
        }
    }
}
