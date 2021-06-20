package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class EmailTest {
    @Nested
    @DisplayName("バリデーションテスト")
    inner class ValidationTest {
        @Test
        fun `メールアドレスが空の場合、例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                Email("")
            }
            Assertions.assertThat(error.message).isEqualTo("メールアドレスの入力は必須です")
        }
        @Test
        fun `メールアドレス以外が入力されている場合例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                Email("hogehoge@hogehoge")
            }
            Assertions.assertThat(error.message).isEqualTo("メールアドレス以外が入力されています")
        }
    }

    @Nested
    @DisplayName("等価判定のテスト")
    inner class EqualsTest {
        @Test
        fun `メールアドレスが同じ場合はtrueを返すこと`() {
            val email = Email("hogehoge@example.com")
            val emailOther = Email(email.mail)

            Assertions.assertThat(email == emailOther).isTrue
        }

        @Test
        fun `メールアドレスが異なる場合はfalseを返すこと`() {
            val email = Email("hogehoge@exmaple.com")
            val emailOther = Email("hugehuge@exmaple.com")

            Assertions.assertThat(email == emailOther).isFalse
        }
    }
}