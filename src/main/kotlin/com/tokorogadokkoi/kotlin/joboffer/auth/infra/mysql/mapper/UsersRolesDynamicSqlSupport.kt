/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UsersRolesDynamicSqlSupport {
    object UsersRoles : SqlTable("users_roles") {
        val userUuid = column<String>("user_uuid", JDBCType.CHAR)

        val roleId = column<Long>("role_id", JDBCType.BIGINT)

        val createdAt = column<Date>("created_at", JDBCType.TIMESTAMP)

        val updatedAt = column<Date>("updated_at", JDBCType.TIMESTAMP)
    }
}