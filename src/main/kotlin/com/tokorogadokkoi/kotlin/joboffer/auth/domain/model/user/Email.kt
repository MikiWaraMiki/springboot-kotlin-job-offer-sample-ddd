package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import kotlin.IllegalArgumentException

/**
 * メールアドレスクラス
 */
class Email(mail: String) {
    /**
     * メールアドレス
     */
    val mail:String = try {
        validateEmail(mail)
        mail
    } catch(e: IllegalArgumentException) {
        throw e
    }


    /**
     * コンストラクタで受け取ったメールアドレスのバリデーションを行う
     * @args mail メールアドレス
     */
    private fun validateEmail(mail: String) {
        if (mail === "") throw IllegalArgumentException("メールアドレスの入力は必須です")
        if (!isValidEmailFormat(mail)) throw IllegalArgumentException("メールアドレス以外が入力されています")
    }

    /**
     * メールアドレスが正しい入力形式が検証を行う
     * @args mail メールアドレス
     * @return return 検証結果
     */
    private fun isValidEmailFormat(mail: String): Boolean {
        val emailRegExpPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+"
        val regex = Regex(pattern = emailRegExpPattern)

        return regex.matches(mail)
    }
}