package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job

import java.math.BigInteger

/**
 * 職種IDクラス
 */
class JobID(val id: Int) {

    override fun toString(): String {
        return id.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as JobID

        return id == other.id
    }
}