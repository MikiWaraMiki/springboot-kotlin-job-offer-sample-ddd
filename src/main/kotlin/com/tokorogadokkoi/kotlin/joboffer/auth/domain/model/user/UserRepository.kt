package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

interface UserRepository {
    /**
     * メールアドレスでユーザを検索
     */
    fun findByEmail(email: Email): User?

    /**
     * ユーザを一件登録する
     */
    fun insertUser(user: User)
}