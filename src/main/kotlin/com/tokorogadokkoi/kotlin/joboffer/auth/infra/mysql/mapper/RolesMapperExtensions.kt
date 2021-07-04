/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper

import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.RolesDynamicSqlSupport.Roles
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.RolesDynamicSqlSupport.Roles.createdAt
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.RolesDynamicSqlSupport.Roles.id
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.RolesDynamicSqlSupport.Roles.name
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.RolesDynamicSqlSupport.Roles.updatedAt
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.records.RolesRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun RolesMapper.count(completer: CountCompleter) =
    countFrom(this::count, Roles, completer)

fun RolesMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Roles, completer)

fun RolesMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun RolesMapper.insert(record: RolesRecord) =
    insert(this::insert, record, Roles) {
        map(id).toProperty("id")
        map(name).toProperty("name")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun RolesMapper.insertMultiple(records: Collection<RolesRecord>) =
    insertMultiple(this::insertMultiple, records, Roles) {
        map(id).toProperty("id")
        map(name).toProperty("name")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun RolesMapper.insertMultiple(vararg records: RolesRecord) =
    insertMultiple(records.toList())

fun RolesMapper.insertSelective(record: RolesRecord) =
    insert(this::insert, record, Roles) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(name).toPropertyWhenPresent("name", record::name)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(id, name, createdAt, updatedAt)

fun RolesMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Roles, completer)

fun RolesMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Roles, completer)

fun RolesMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Roles, completer)

fun RolesMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun RolesMapper.update(completer: UpdateCompleter) =
    update(this::update, Roles, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: RolesRecord) =
    apply {
        set(id).equalTo(record::id)
        set(name).equalTo(record::name)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: RolesRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(name).equalToWhenPresent(record::name)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }

fun RolesMapper.updateByPrimaryKey(record: RolesRecord) =
    update {
        set(name).equalTo(record::name)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
        where(id, isEqualTo(record::id))
    }

fun RolesMapper.updateByPrimaryKeySelective(record: RolesRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
        where(id, isEqualTo(record::id))
    }