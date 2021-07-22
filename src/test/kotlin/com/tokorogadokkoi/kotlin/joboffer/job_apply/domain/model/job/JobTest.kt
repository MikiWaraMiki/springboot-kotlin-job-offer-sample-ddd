package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class JobTest {
    @Nested
    @DisplayName("等価判定のテスト")
    inner class EqualsTest() {
        @Test
        fun `idが同一の場合は、等価とみなされること`() {
            val firstJob = Job(
                JobID(1),
                JobName("職種1")
            )
            val secondJob = Job(
                JobID(1),
                JobName("職種2")
            )

            Assertions.assertThat(firstJob == secondJob).isTrue
        }

        @Test
        fun `idが異なる場合は、等価とみなされないこと`() {
            val firstJob = Job(
                JobID(1),
                JobName("職種1")
            )
            val secondJob = Job(
                JobID(2),
                JobName("職種1")
            )

            Assertions.assertThat(firstJob == secondJob).isFalse
        }
    }
}