/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.tokorogadokkoi.kotlin.joboffer.infra.mysql.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UserConnectionInformationsDynamicSqlSupport {
    object UserConnectionInformations : SqlTable("user_connection_informations") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val userUuid = column<String>("user_uuid", JDBCType.CHAR)

        val connectionType = column<String>("connection_type", JDBCType.VARCHAR)

        val createdAt = column<Date>("created_at", JDBCType.TIMESTAMP)

        val updatedAt = column<Date>("updated_at", JDBCType.TIMESTAMP)
    }
}