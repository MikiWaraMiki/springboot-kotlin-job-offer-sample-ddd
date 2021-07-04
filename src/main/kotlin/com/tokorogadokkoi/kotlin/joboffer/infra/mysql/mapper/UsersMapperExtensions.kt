/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.tokorogadokkoi.kotlin.joboffer.infra.mysql.mapper

import com.tokorogadokkoi.kotlin.joboffer.infra.mysql.mapper.UsersDynamicSqlSupport.Users
import com.tokorogadokkoi.kotlin.joboffer.infra.mysql.mapper.UsersDynamicSqlSupport.Users.createdAt
import com.tokorogadokkoi.kotlin.joboffer.infra.mysql.mapper.UsersDynamicSqlSupport.Users.email
import com.tokorogadokkoi.kotlin.joboffer.infra.mysql.mapper.UsersDynamicSqlSupport.Users.updatedAt
import com.tokorogadokkoi.kotlin.joboffer.infra.mysql.mapper.UsersDynamicSqlSupport.Users.uuid
import com.tokorogadokkoi.kotlin.joboffer.infra.mysql.records.UsersRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UsersMapper.count(completer: CountCompleter) =
    countFrom(this::count, Users, completer)

fun UsersMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Users, completer)

fun UsersMapper.deleteByPrimaryKey(uuid_: String) =
    delete {
        where(uuid, isEqualTo(uuid_))
    }

fun UsersMapper.insert(record: UsersRecord) =
    insert(this::insert, record, Users) {
        map(uuid).toProperty("uuid")
        map(email).toProperty("email")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UsersMapper.insertMultiple(records: Collection<UsersRecord>) =
    insertMultiple(this::insertMultiple, records, Users) {
        map(uuid).toProperty("uuid")
        map(email).toProperty("email")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UsersMapper.insertMultiple(vararg records: UsersRecord) =
    insertMultiple(records.toList())

fun UsersMapper.insertSelective(record: UsersRecord) =
    insert(this::insert, record, Users) {
        map(uuid).toPropertyWhenPresent("uuid", record::uuid)
        map(email).toPropertyWhenPresent("email", record::email)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(uuid, email, createdAt, updatedAt)

fun UsersMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Users, completer)

fun UsersMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Users, completer)

fun UsersMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Users, completer)

fun UsersMapper.selectByPrimaryKey(uuid_: String) =
    selectOne {
        where(uuid, isEqualTo(uuid_))
    }

fun UsersMapper.selectByEmail(email_: String) =
    selectOne {
        where(email, isEqualTo(email_))
    }

fun UsersMapper.update(completer: UpdateCompleter) =
    update(this::update, Users, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UsersRecord) =
    apply {
        set(uuid).equalTo(record::uuid)
        set(email).equalTo(record::email)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UsersRecord) =
    apply {
        set(uuid).equalToWhenPresent(record::uuid)
        set(email).equalToWhenPresent(record::email)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }

fun UsersMapper.updateByPrimaryKey(record: UsersRecord) =
    update {
        set(email).equalTo(record::email)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
        where(uuid, isEqualTo(record::uuid))
    }

fun UsersMapper.updateByPrimaryKeySelective(record: UsersRecord) =
    update {
        set(email).equalToWhenPresent(record::email)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
        where(uuid, isEqualTo(record::uuid))
    }
