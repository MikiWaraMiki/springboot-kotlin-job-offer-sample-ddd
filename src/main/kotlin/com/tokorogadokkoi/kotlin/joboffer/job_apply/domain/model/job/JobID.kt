package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job

import java.math.BigInteger

/**
 * 職種IDクラス
 */
class JobID(val id: BigInteger) {

    override fun toString(): String {
        return id.toString()
    }
}