package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

import com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job.Job

/**
 * 利用者の経験職種一覧
 */
class UserExperienceJobList() {
    private val jobList = mutableListOf<Job>()

    fun length(): Int {
        return jobList.size
    }

    fun addJob(job: Job) {
        if (isExperienced(job)) {
            throw IllegalArgumentException("すでに登録されている職種を追加することはできません")
        }
        jobList.add(job)
    }

    fun removeJob(job: Job) {
        if(!isExperienced(job)) {
            throw NoSuchElementException("登録されていない職種を削除することはできません")
        }
        jobList.removeAll { it == job }
    }

    private fun isExperienced(job: Job): Boolean {
        return jobList.contains(job)
    }
}