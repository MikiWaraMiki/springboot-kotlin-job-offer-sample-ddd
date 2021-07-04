package com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.user

import com.github.guepardoapps.kulid.ULID

/**
 * ユーザIDクラス
 * ULIDをベースに生成する
 */
class UserID(_id: String) {
    /**
     * UUID
     */
    private val id: String

    init {
        if (_id === "") {
            throw IllegalArgumentException("ユーザIDは必須です")
        }
        id = _id
    }

    companion object {
        fun generateUserId(): UserID {
            return UserID(ULID.random())
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as UserID

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode() * 31
    }
    /**
     * UUIDの文字列
     */
    override fun toString(): String {
        return id
    }
}