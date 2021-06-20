package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class EmailTest {
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