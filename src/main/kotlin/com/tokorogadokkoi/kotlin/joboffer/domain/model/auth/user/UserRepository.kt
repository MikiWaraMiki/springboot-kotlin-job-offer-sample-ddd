package com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.user

interface UserRepository {
    fun findByEmail(email: Email): User?
}