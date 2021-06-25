package com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.user

import com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.role.Role

/**
 * ユーザが保持するロール
 */
class UserHavingRoleList {
    val roleList: MutableList<Role> = mutableListOf()

    /**
     * ロールを追加する
     * @param role 追加するロール
     */
    fun addRole(role: Role) {
        roleList.add(role)
    }

    /**
     * 引数で与えられたロールを保持しているか判定を行う
     * @param role 保持しているか判定を行うロール
     */
    fun hasRole(targetRole: Role): Boolean {
        val result = roleList.firstOrNull { role -> role == targetRole
        } ?: return false

        return true
    }
}