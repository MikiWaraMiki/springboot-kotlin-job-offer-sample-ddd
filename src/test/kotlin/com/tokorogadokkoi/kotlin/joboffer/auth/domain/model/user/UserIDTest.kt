package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class UserIDTest {
    @Test
    fun `IDが生成されること`() {
        val ulid = UserID()
        Assertions.assertThat(ulid.toString()).isNotNull
        Assertions.assertThat(ulid.toString().length).isEqualTo(26)
    }

    @Nested
    @DisplayName("等価判定のテスト")
    inner class EqualsTest {
        @Test
        fun `同じIDの場合はtrueを返すこと`() {
            val userId = UserID()

            Assertions.assertThat(userId == userId).isTrue()
        }

        @Test
        fun `異なるIDの場合はfalseを返すこと`() {
            val userId = UserID()

            Assertions.assertThat(userId == UserID()).isFalse()
        }
    }
}