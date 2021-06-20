package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import com.github.guepardoapps.kulid.ULID
import java.util.*

/**
 * ユーザUUIDクラス
 */
class UserID() {
    /**
     * UUID
     */
    private val id = generateULID()

    /**
     * UUIDの文字列
     */
    override fun toString(): String {
        return id
    }

    private fun generateULID(): String {
        return ULID.random()
    }
}