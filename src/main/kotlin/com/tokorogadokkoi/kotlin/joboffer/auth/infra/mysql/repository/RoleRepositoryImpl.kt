package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.repository

import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.Role
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.RoleRepository
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.RolesMapper
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.select
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.selectByName
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.selectOne
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.records.RolesRecord

class RoleRepositoryImpl(
    private val rolesMapper: RolesMapper
): RoleRepository {

    /**
     * 全てのロールを取得
     */
    override fun findByName(roleName: String): Role? {
        return rolesMapper.selectByName(roleName)?.let {
            toModel(it)
        }
    }

    private fun toModel(roleRecord: RolesRecord): Role {
        if (roleRecord.id == null) throw IllegalArgumentException("ロールIDが保存されていません")
        if (roleRecord.name == null || roleRecord.name == "") throw IllegalArgumentException("ロール名が登録されていません")

        return Role(
            id = roleRecord.id!!.toInt(),
            _name = roleRecord.name!!
        )
    }

}