package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.repository

import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.*
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.UsersMapper
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.insert
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.mapper.selectByEmail
import com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.records.UsersRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRepositoryImpl(
    val usersMapper: UsersMapper
): UserRepository {

    /**
     * メールアドレスからユーザを取得する
     * @param email 検索対象のメールアドレス
     * @return User? 存在する場合はUserモデルを返却 存在しない場合はnullを返却
     */
    override fun findByEmail(email: Email): User? {
        return usersMapper.selectByEmail(email.toString())?.let {
            toModel(it)
        }
    }

    /**
     * ユーザを一件登録する
     * @param user Userオブジェクト
     */
    override fun insertUser(user: User) {
        val usersRecord = toRecord(user)
        usersMapper.insert(usersRecord)
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

    /**
     * Recordクラスへ変換する
     */
    private fun toRecord(user: User): UsersRecord {
        return UsersRecord(
            uuid = user.userId.toString(),
            email = user.email.toString()
        )
    }

}