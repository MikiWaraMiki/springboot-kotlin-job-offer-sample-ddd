package com.tokorogadokkoi.kotlin.joboffer.domain.model.auth.role

interface RoleRepository {
    fun findAll(): List<Role>
}