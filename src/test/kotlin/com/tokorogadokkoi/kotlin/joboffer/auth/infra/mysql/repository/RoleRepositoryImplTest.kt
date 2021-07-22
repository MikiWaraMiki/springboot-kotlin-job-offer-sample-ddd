package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.repository

import com.tokorogadokkoi.kotlin.joboffer.helper.annotation.MybatisMapperTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import

@MybatisMapperTest
@Import(RoleRepositoryImpl::class)
class RoleRepositoryImplTest {
    @Autowired
    lateinit var roleRepositoryImpl: RoleRepositoryImpl

    @Nested
    @DisplayName("findByNameのテスト")
    inner class FindByNameTest() {
        @Test
        fun `指定された名前のロールが存在する場合はRoleオブジェクトを返すこと`() {
            val roleName = "client"
            val role = roleRepositoryImpl.findByName(roleName)

            Assertions.assertThat(role).isNotNull
            Assertions.assertThat(role.toString()).isEqualTo(roleName)
        }
        @Test
        fun `指定された名前のロールが存在しない場合はnullを返すこと`() {
            val roleName = "not_found"
            val role = roleRepositoryImpl.findByName(roleName)

            Assertions.assertThat(role).isNull()
        }
    }
}