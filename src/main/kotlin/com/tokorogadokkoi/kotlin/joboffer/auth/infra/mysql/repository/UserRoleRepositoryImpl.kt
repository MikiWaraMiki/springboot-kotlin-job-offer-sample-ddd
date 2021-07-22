package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.repository

import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.Role
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.User
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.UserRoleRepository
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.UsersRolesMapper
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.insert
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.records.UsersRolesRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRoleRepositoryImpl(
    val mapper: UsersRolesMapper
): UserRoleRepository {

    /**
     * ユーザにロールを付与する
     * @param user 付与対象のUserオブジェクト
     * @param role 付与するRoleオブジェクト
     */
    override fun insertUserRole(user: User, role: Role) {
        mapper.insert(toRecord(user, role))
    }

    /**
     * Recordオブジェクトに変換する
     * @param user Userオブジェクト
     * @param role Roleオブジェクト
     */
    private fun toRecord(user: User, role: Role): UsersRolesRecord {
        return UsersRolesRecord(
            userUuid = user.userId.toString(),
            roleId = role.id.toLong()
        )
    }
}