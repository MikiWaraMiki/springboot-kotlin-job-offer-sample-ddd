package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class JobNameTest {

    @Nested
    @DisplayName("バリデーションテスト")
    inner class ValidationTest() {
        @Test
        fun `職種名が入力されていない場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                JobName("")
            }

            Assertions.assertThat(error.message).isEqualTo("職種名の入力は必須です")
        }

        @Test
        fun `職種名が100文字を超えて入力されている場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                JobName("a".repeat(101))
            }

            Assertions.assertThat(error.message).isEqualTo("職種名は100文字以内で入力してください")
        }
    }
}