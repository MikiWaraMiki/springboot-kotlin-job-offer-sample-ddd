package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoleTest {

    @Test
    fun `ロール名が指定されていない場合エラーが発生する`() {
        val error = assertThrows<IllegalArgumentException> {
            Role("")
        }

        Assertions.assertThat(error.message).isEqualTo("ロール名の入力は必須です")
    }

    @Test
    fun `ロール名が256文字以上の場合はエラーが発生する`() {
        val error = assertThrows<IllegalArgumentException> {
            Role("a".repeat(256))
        }

        Assertions.assertThat(error.message).isEqualTo("ロール名は255文字以内で入力してください")
    }
}