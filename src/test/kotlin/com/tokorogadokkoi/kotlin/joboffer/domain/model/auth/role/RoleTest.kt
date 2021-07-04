package com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.role

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoleTest {

    @Nested
    @DisplayName("バリデーション")
    inner class ValidateTest {
        @Test
        fun `ロール名が指定されていない場合エラーが発生する`() {
            val error = assertThrows<IllegalArgumentException> {
                Role(1,"")
            }

            Assertions.assertThat(error.message).isEqualTo("ロール名の入力は必須です")
        }

        @Test
        fun `ロール名が256文字以上の場合はエラーが発生する`() {
            val error = assertThrows<IllegalArgumentException> {
                Role(1, "a".repeat(256))
            }

            Assertions.assertThat(error.message).isEqualTo("ロール名は255文字以内で入力してください")
        }
    }

    @Nested
    @DisplayName("等価性判定")
    inner class EqualsTest {
        @Test
        fun `idが同じであれば等価と判定すること`() {
            val roleA = Role(1, "role_a")
            val roleB = Role(1, "role_a")

            Assertions.assertThat(roleA == roleB).isTrue
        }

        @Test
        fun `idが異なる場合は等価と判定されないこと`() {
            val roleA = Role(1, "role_a")
            val roleB = Role(2, "role_a")

            Assertions.assertThat(roleA == roleB).isFalse
        }
    }
}