package com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.user

import kotlin.IllegalArgumentException

/**
 * メールアドレスクラス
 */
class Email(_mail: String) {
    /**
     * メールアドレス
     */
    val mail:String = try {
        validateEmail(_mail)
        _mail
    } catch(e: IllegalArgumentException) {
        throw e
    }

    /**
     * 等価判定
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Email

        if (mail != other.mail) return false

        return true
    }

    override fun hashCode(): Int {
        return mail.hashCode() * 31
    }


    /**
     * コンストラクタで受け取ったメールアドレスのバリデーションを行う
     * @args mail メールアドレス
     */
    private fun validateEmail(_mail: String) {
        if (_mail === "") throw IllegalArgumentException("メールアドレスの入力は必須です")
        if (!isValidEmailFormat(_mail)) throw IllegalArgumentException("メールアドレス以外が入力されています")
    }

    /**
     * メールアドレスが正しい入力形式が検証を行う
     * @args mail メールアドレス
     * @return return 検証結果
     */
    private fun isValidEmailFormat(_mail: String): Boolean {
        val emailRegExpPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+"
        val regex = Regex(pattern = emailRegExpPattern)

        return regex.matches(_mail)
    }
}