package com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user

import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.role.Role
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class UserHavingRoleListTest {
    @Nested
    @DisplayName("hasRoleのテスト")
    inner class HasRoleTest() {
        @Test
        fun `ロールを保持している場合はtrueを返すこと`() {
            val roleList = UserHavingRoleList()
            val role = Role(1, "role_a")
            roleList.addRole(role)

            Assertions.assertThat(roleList.hasRole(role)).isTrue
        }
        @Test
        fun `ロールを保持していない場合はfalseを返すこと`() {
            val roleList = UserHavingRoleList()
            roleList.addRole(Role(1, "role_a"))

            Assertions.assertThat(roleList.hasRole(Role(2, "role_b"))).isFalse()
        }
    }

    @Nested
    @DisplayName("addRoleのテスト")
    inner class AddRoleTest() {
        @Test
        fun `ロールが追加されること`() {
            val roleList = UserHavingRoleList()
            val role = Role(1, "role")
            roleList.addRole(role)

            Assertions.assertThat(roleList.hasRole(role)).isTrue
        }
    }
}