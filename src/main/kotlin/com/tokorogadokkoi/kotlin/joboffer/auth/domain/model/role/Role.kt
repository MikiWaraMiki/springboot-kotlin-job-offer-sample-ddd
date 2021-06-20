package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role

/**
 * ロールクラス
 */
class Role(private val id: Int, _name: String) {
    private val name: String

    init {
        validateName(_name)

        name = _name
    }

    /**
     * 等価性判定
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Role

        if (id != other.id) return false

        return true
    }

    /**
     * ハッシュコード計算
     */
    override fun hashCode(): Int {
        return 31 * name.hashCode() + id
    }

    /**
     * 文字列
     */
    override fun toString(): String {
        return name
    }

    /**
     * ロール名のバリデーション
     */
    private fun validateName(name: String) {
        if (name == "") throw IllegalArgumentException("ロール名の入力は必須です")

        if (name.length > 255) throw java.lang.IllegalArgumentException("ロール名は255文字以内で入力してください")
    }
}