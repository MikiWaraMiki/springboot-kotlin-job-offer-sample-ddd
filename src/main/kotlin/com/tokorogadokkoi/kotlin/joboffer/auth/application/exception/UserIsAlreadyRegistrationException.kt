package com.tokorogadokkoi.kotlin.joboffer.auth.application.exception

import com.tokorogadokkoi.kotlin.joboffer.auth.presentation.api.exception.BadRequestException
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * ユーザがすでに登録済みの場合に発生する例外クラス
 */
class UserIsAlreadyRegistrationException() : BadRequestException(msg = "メールアドレスはすでに登録済みです")