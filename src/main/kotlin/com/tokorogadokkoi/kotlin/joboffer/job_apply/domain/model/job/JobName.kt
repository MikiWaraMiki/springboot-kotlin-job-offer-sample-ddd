package com.tokorogadokkoi.kotlin.joboffer.job_apply.domain.model.job

/**
 * 職種名クラス
 */
class JobName(_name: String) {
    val name: String

    init {
        if(_name == "") {
            throw IllegalArgumentException("職種名の入力は必須です")
        }

        if(!isNameLengthWithIn100(_name)) {
            throw IllegalArgumentException("職種名は100文字以内で入力してください")
        }

        name = _name

    }

    override fun toString(): String {
        return name
    }

    private fun isNameLengthWithIn100(_name: String): Boolean {
        return _name.length <= 100
    }

}