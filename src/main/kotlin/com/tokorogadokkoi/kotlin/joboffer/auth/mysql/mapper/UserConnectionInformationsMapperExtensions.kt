/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper

import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.UserConnectionInformationsDynamicSqlSupport.UserConnectionInformations
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.UserConnectionInformationsDynamicSqlSupport.UserConnectionInformations.connectionType
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.UserConnectionInformationsDynamicSqlSupport.UserConnectionInformations.createdAt
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.UserConnectionInformationsDynamicSqlSupport.UserConnectionInformations.id
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.UserConnectionInformationsDynamicSqlSupport.UserConnectionInformations.updatedAt
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.UserConnectionInformationsDynamicSqlSupport.UserConnectionInformations.userUuid
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.records.UserConnectionInformationsRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserConnectionInformationsMapper.count(completer: CountCompleter) =
    countFrom(this::count, UserConnectionInformations, completer)

fun UserConnectionInformationsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, UserConnectionInformations, completer)

fun UserConnectionInformationsMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserConnectionInformationsMapper.insert(record: UserConnectionInformationsRecord) =
    insert(this::insert, record, UserConnectionInformations) {
        map(id).toProperty("id")
        map(userUuid).toProperty("userUuid")
        map(connectionType).toProperty("connectionType")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UserConnectionInformationsMapper.insertMultiple(records: Collection<UserConnectionInformationsRecord>) =
    insertMultiple(this::insertMultiple, records, UserConnectionInformations) {
        map(id).toProperty("id")
        map(userUuid).toProperty("userUuid")
        map(connectionType).toProperty("connectionType")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UserConnectionInformationsMapper.insertMultiple(vararg records: UserConnectionInformationsRecord) =
    insertMultiple(records.toList())

fun UserConnectionInformationsMapper.insertSelective(record: UserConnectionInformationsRecord) =
    insert(this::insert, record, UserConnectionInformations) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(userUuid).toPropertyWhenPresent("userUuid", record::userUuid)
        map(connectionType).toPropertyWhenPresent("connectionType", record::connectionType)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(id, userUuid, connectionType, createdAt, updatedAt)

fun UserConnectionInformationsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, UserConnectionInformations, completer)

fun UserConnectionInformationsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, UserConnectionInformations, completer)

fun UserConnectionInformationsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, UserConnectionInformations, completer)

fun UserConnectionInformationsMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserConnectionInformationsMapper.update(completer: UpdateCompleter) =
    update(this::update, UserConnectionInformations, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserConnectionInformationsRecord) =
    apply {
        set(id).equalTo(record::id)
        set(userUuid).equalTo(record::userUuid)
        set(connectionType).equalTo(record::connectionType)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserConnectionInformationsRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(userUuid).equalToWhenPresent(record::userUuid)
        set(connectionType).equalToWhenPresent(record::connectionType)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }

fun UserConnectionInformationsMapper.updateByPrimaryKey(record: UserConnectionInformationsRecord) =
    update {
        set(userUuid).equalTo(record::userUuid)
        set(connectionType).equalTo(record::connectionType)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
        where(id, isEqualTo(record::id))
    }

fun UserConnectionInformationsMapper.updateByPrimaryKeySelective(record: UserConnectionInformationsRecord) =
    update {
        set(userUuid).equalToWhenPresent(record::userUuid)
        set(connectionType).equalToWhenPresent(record::connectionType)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
        where(id, isEqualTo(record::id))
    }