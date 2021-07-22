package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class UserIDTest {

    @Nested
    @DisplayName("バリデーションテスト")
    inner class ValidationTest {
        @Test
        fun `ユーザIDからから文字の場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                UserID("")
            }
            Assertions.assertThat(error.message).isEqualTo("IDは必須です")
        }
    }
}