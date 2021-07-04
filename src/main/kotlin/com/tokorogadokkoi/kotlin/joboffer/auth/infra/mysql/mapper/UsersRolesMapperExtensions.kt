/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper

import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.UsersRolesDynamicSqlSupport.UsersRoles
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.UsersRolesDynamicSqlSupport.UsersRoles.createdAt
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.UsersRolesDynamicSqlSupport.UsersRoles.roleId
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.UsersRolesDynamicSqlSupport.UsersRoles.updatedAt
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.UsersRolesDynamicSqlSupport.UsersRoles.userUuid
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.records.UsersRolesRecord
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UsersRolesMapper.count(completer: CountCompleter) =
    countFrom(this::count, UsersRoles, completer)

fun UsersRolesMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, UsersRoles, completer)

fun UsersRolesMapper.insert(record: UsersRolesRecord) =
    insert(this::insert, record, UsersRoles) {
        map(userUuid).toProperty("userUuid")
        map(roleId).toProperty("roleId")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UsersRolesMapper.insertMultiple(records: Collection<UsersRolesRecord>) =
    insertMultiple(this::insertMultiple, records, UsersRoles) {
        map(userUuid).toProperty("userUuid")
        map(roleId).toProperty("roleId")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UsersRolesMapper.insertMultiple(vararg records: UsersRolesRecord) =
    insertMultiple(records.toList())

fun UsersRolesMapper.insertSelective(record: UsersRolesRecord) =
    insert(this::insert, record, UsersRoles) {
        map(userUuid).toPropertyWhenPresent("userUuid", record::userUuid)
        map(roleId).toPropertyWhenPresent("roleId", record::roleId)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(userUuid, roleId, createdAt, updatedAt)

fun UsersRolesMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, UsersRoles, completer)

fun UsersRolesMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, UsersRoles, completer)

fun UsersRolesMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, UsersRoles, completer)

fun UsersRolesMapper.update(completer: UpdateCompleter) =
    update(this::update, UsersRoles, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UsersRolesRecord) =
    apply {
        set(userUuid).equalTo(record::userUuid)
        set(roleId).equalTo(record::roleId)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UsersRolesRecord) =
    apply {
        set(userUuid).equalToWhenPresent(record::userUuid)
        set(roleId).equalToWhenPresent(record::roleId)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }