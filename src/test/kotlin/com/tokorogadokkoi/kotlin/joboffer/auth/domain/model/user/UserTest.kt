package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class UserTest {
    @Nested
    @DisplayName("changeEmailメソッドのテスト")
    inner class ChangeEmailTest {
        @Test
        fun `メールアドレスが変更できること`() {
            val expectedEmail = Email("hogehoge@example.com")
            val user = User(
                UserID.generateUserId(),
                Email("fugafuga@example.com"),
                UserHavingRoleList()
            )

            user.changeEmail(expectedEmail)

            Assertions.assertThat(user.email == expectedEmail).isTrue
        }
    }

    @Nested
    @DisplayName("等価判定のテスト")
    internal class EqualsTest {
        @Test
        fun `ユーザIDとメールアドレスが同一の場合はtrueを返すこと`() {
            val email = Email("hogehoge@exmaple.com")
            val userId = UserID.generateUserId()
            val user = User(
                userId,
                email,
                UserHavingRoleList()
            )

            val otherUser = User(
                userId,
                email,
                UserHavingRoleList()
            )

            Assertions.assertThat(user == otherUser).isTrue
        }

        @Test
        fun `ユーザIDが異なる場合はfalseを返すこと`() {
            val email = Email("hogehoge@exmaple.com")
            val user = User(
                UserID.generateUserId(),
                email,
                UserHavingRoleList()
            )

            val otherUser = User(
                UserID.generateUserId(),
                email,
                UserHavingRoleList()
            )

            Assertions.assertThat(user == otherUser).isFalse
        }

        @Test
        fun `メールアドレスが異なる場合はfalseを返すこと`() {
            val userId = UserID.generateUserId()
            val user = User(
                userId,
                Email("hogehoge@exmaple.com"),
                UserHavingRoleList()
            )

            val otherUser = User(
                userId,
                Email("fugafuga@example.com"),
                UserHavingRoleList()
            )

            Assertions.assertThat(user == otherUser).isFalse
        }
    }
}