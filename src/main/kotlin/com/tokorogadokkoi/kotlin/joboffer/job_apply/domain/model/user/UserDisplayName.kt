package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.user

/**
 * アプリケーションで表示するユーザー名
 */
class UserDisplayName(_name: String) {
    val name: String

    init {
        if (_name == "") {
            throw IllegalArgumentException("表示名が入力されていません")
        }

        if (!isLengthWithIn30(_name)) {
            throw IllegalArgumentException("表示名は30文字以内で入力してください")
        }

        if (!isValidFormat(_name)) {
            throw IllegalArgumentException("表示名には英数字と記号(_-のみ)が利用できます")
        }

        name = _name
    }

    override fun toString(): String {
        return name
    }

    private fun isLengthWithIn30(_name: String): Boolean {
        return _name.length <= 30
    }

    private fun isValidFormat(_name: String): Boolean {
        val regexpPattern = "[a-zA-Z0-9_-]+"
        val regex = Regex(pattern = regexpPattern)

        return regex.matches(_name)
    }
}