package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

import com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job.Job
import com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job.JobID
import com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job.JobName
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserExperienceJobListTest {
    @Nested
    @DisplayName("経験職種追加テスト")
    inner class AddJobTest() {
        @Test
        fun `登録されていない職種の場合は、追加されていること`() {
            val list = UserExperienceJobList()
            list.addJob(
                Job(
                    JobID(1),
                    JobName("職種1")
                )
            )
            Assertions.assertThat(list.length()).isEqualTo(1)
        }

        @Test
        fun `すでに登録されている職種の場合は、例外が発生すること`() {
            val list = UserExperienceJobList()
            val job =  Job(
                JobID(1),
                JobName("職種1")
            )
            list.addJob(job)

            val error = assertThrows<IllegalArgumentException> {
                list.addJob(job)
            }

            Assertions.assertThat(error.message).isEqualTo("すでに登録されている職種を追加することはできません")
        }
    }

    @Nested
    @DisplayName("職種の削除")
    inner class RemoveJobTest() {
        @Test
        fun `登録されている職種を削除する場合は削除されること`() {
            val list = UserExperienceJobList()
            val job =  Job(
                JobID(1),
                JobName("職種1")
            )
            list.addJob(job)

            list.removeJob(job)

            Assertions.assertThat(list.length()).isEqualTo(0)
        }

        @Test
        fun `登録されていない職種を削除する場合は例外が発生すること`() {
            val list = UserExperienceJobList()
            val job =  Job(
                JobID(1),
                JobName("職種1")
            )
            val error = assertThrows<NoSuchElementException> {
                list.removeJob(job)
            }

            Assertions.assertThat(error.message).isEqualTo("登録されていない職種を削除することはできません")
        }
    }
}