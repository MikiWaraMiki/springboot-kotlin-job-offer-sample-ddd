package com.tokorogadokkoi.kotlin.joboffer.auth.mysql.repository

import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.*
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.UsersMapper
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper.selectByEmail
import com.tokorogadokkoi.kotlin.joboffer.auth.mysql.records.UsersRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRepositoryImpl(
    val usersMapper: UsersMapper
): UserRepository {

    /**
     * メールアドレスからユーザを取得する
     */
    override fun findByEmail(email: Email): User? {
        return usersMapper.selectByEmail(email.mail)?.let {
            toModel(it)
        }
    }

    /**
     * ドメインモデルへ変換する
     */
    private fun toModel(record: UsersRecord): User {
        val userID = record.uuid?.let { UserID(it) } ?:
            throw IllegalArgumentException("ユーザIDが保存されていません")
        val email = record.email?.let { Email(it) } ?:
            throw IllegalArgumentException("メールアドレスが保存されていません")
        return User(
            userID,
            email,
            UserHavingRoleList()
        )
    }

}