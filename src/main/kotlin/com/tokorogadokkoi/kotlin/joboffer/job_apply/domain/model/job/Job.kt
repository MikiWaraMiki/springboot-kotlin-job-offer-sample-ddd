package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job


class Job(val id: JobID, val name: JobName) {

    override fun toString(): String {
        return name.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Job

        return id == other.id
    }
}