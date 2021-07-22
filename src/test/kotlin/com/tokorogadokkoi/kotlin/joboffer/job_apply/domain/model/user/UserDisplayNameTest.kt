package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserDisplayNameTest {

    @Nested
    @DisplayName("バリデーションテスト")
    inner class ValidationTest() {

        @Test
        fun `30文字以内で許可されている文字列を利用している場合はオブジェクトを生成できること`() {
            val rawString = "a".repeat(28) + "-_"
            val displayName = UserDisplayName(rawString)

            Assertions.assertThat(displayName.name).isEqualTo(rawString)
        }
        @Test
        fun `表示名が入力されていない場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                UserDisplayName("")
            }

            Assertions.assertThat(error.message).isEqualTo("表示名が入力されていません")
        }

        @Test
        fun `30文字以上で入力されている場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                UserDisplayName("a".repeat(31))
            }

            Assertions.assertThat(error.message).isEqualTo("表示名は30文字以内で入力してください")
        }

        @Test
        fun `英数字以外を利用している場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                UserDisplayName("あ".repeat(30))
            }

            Assertions.assertThat(error.message).isEqualTo("表示名には英数字と記号(_-のみ)が利用できます")
        }

        @Test
        fun `_,-以外の記号を利用している場合は例外が発生すること`() {
            val error = assertThrows<IllegalArgumentException> {
                UserDisplayName("a-i.u")
            }

            Assertions.assertThat(error.message).isEqualTo("表示名には英数字と記号(_-のみ)が利用できます")
        }
    }
}