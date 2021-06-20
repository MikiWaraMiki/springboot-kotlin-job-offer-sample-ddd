package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role

/**
 * ロールクラス
 */
class Role(_name: String) {
    private val name: String

    init {
        validateName(_name)

        name = _name
    }

    private fun validateName(name: String) {
        if (name == "") throw IllegalArgumentException("ロール名の入力は必須です")

        if (name.length > 255) throw java.lang.IllegalArgumentException("ロール名は255文字以内で入力してください")
    }
}