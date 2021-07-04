package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role

interface RoleRepository {
    fun findAll(): List<Role>
}