package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job


class Job(val id: JobID, val name: JobName) {

    override fun toString(): String {
        return name.toString()
    }
}