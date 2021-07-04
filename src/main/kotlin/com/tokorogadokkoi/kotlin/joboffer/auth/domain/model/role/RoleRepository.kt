package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role

interface RoleRepository {
    fun findByName(roleName: String): Role?
}