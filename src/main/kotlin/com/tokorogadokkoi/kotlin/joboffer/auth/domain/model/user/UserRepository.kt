package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

interface UserRepository {
    fun findByEmail(email: Email): User?
}