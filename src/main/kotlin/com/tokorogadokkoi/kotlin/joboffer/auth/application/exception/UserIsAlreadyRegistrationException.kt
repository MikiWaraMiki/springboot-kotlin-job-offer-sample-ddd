package com.tokorogadokkoi.kotlin.joboffer.auth.application.exception

import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * ユーザがすでに登録済みの場合に発生する例外クラス
 */
class UserIsAlreadyRegistrationException(
    val statusCode: String = "400",
    val msg: String? = "メールアドレスはすでに登録済みです"
) : RuntimeException(msg)