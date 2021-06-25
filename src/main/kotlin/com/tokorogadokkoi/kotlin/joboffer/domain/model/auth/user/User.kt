package com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.user

import com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.role.Role

/**
 * ユーザクラス
 * @param userID ユーザーID
 * @param email メールアドレス
 */
class User(_userID: UserID, _email: Email, _havingRoleList: UserHavingRoleList) {
    val userId = _userID

    var email = _email
        private set

    var havingRoleList = _havingRoleList
        private set

    /**
     * メールアドレスを変更する
     * @param email メールアドレス
     */
    fun changeEmail(email: Email) {
        this.email = email
    }

    /**
     * ユーザにロールを追加する
     */
    fun addRole(role: Role) {
        havingRoleList.addRole(role)
    }

    /**
     * ロールの保持判定
     * @param role 判定するロール
     */
    fun hasRole(role: Role): Boolean {
        return havingRoleList.hasRole(role)
    }

    /**
     * 等価判定
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as User

        if (userId != other.userId) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        val mailHash = this.email.hashCode() * 31
        return mailHash + userId.hashCode()
    }
}