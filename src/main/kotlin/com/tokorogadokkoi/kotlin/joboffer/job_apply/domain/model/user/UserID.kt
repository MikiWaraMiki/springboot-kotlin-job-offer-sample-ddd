package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

/**
 * ユーザID
 */
class UserID(_id: String) {
    val id: String

    init {
        if (_id == "") {
            throw IllegalArgumentException("IDは必須です")
        }
        id = _id
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