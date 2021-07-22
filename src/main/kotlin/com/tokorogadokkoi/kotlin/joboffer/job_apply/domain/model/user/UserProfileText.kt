package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

/**
 * 求人応募システム利用者の自己紹介文クラス
 */
class UserProfileText(_text: String) {
    val text: String

    init {
        if(_text == "") {
            throw IllegalArgumentException("自己紹介文の入力は必須です")
        }
        if(!isLengthWithIn2000(_text)) {
            throw IllegalArgumentException("自己紹介文は2000文字以内で入力してください")
        }

        text = _text
    }

    override fun toString(): String {
        return text
    }

    private fun isLengthWithIn2000(_text: String): Boolean {
        return _text.length <= 2000
    }
}