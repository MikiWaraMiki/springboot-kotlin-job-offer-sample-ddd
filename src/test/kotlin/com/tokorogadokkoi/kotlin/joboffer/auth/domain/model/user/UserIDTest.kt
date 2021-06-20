package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class UserIDTest {
    @Test
    fun `IDが生成されること`() {
        val ulid = UserID()
        Assertions.assertThat(ulid.toString()).isNotNull
        Assertions.assertThat(ulid.toString().length).isEqualTo(26)
    }
}