package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.Role

interface UserRoleRepository {
    /**
     * ユーザにロールを付与する
     * @param user 付与対象のUserオブジェクト
     * @param role 付与するRoleオブジェクト
     */
    fun insertUserRole(user: User, role: Role)
}