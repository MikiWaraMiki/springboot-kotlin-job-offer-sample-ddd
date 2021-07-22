package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserProfileTextTest {
    @Nested
    @DisplayName("バリデーションテスト")
    inner class ValidationTest() {
        @Test
        fun `プロフィール文が入力されていない場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                UserProfileText("")
            }

            Assertions.assertThat(error.message).isEqualTo("自己紹介文の入力は必須です")
        }
        @Test
        fun `2000文字を超えて入力されている場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                UserProfileText("a".repeat(2001))
            }

            Assertions.assertThat(error.message).isEqualTo("自己紹介文は2000文字以内で入力してください")
        }
    }
}