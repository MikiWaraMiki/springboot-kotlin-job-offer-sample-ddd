package com.tokorogadokkoi.kotlin.joboffer.auth.infra.mysql.repository

import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.Email
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.User
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.UserHavingRoleList
import com.tokorogadokkoi.kotlin.joboffer.auth.domain.model.user.UserID
import com.tokorogadokkoi.kotlin.joboffer.helper.annotation.MybatisMapperTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlConfig
import org.springframework.transaction.annotation.Transactional

@MybatisMapperTest
@Import(UserRepositoryImpl::class)
class UserRepositoryImplTest {
    @Autowired
    lateinit var userRepository: UserRepositoryImpl

    @Nested
    @DisplayName("findByEmailのテスト")
    inner class FindByEmailTest() {
        @Test
        @Sql(scripts = ["classpath:sql/test-user-data.sql"], config = SqlConfig(encoding = "utf-8"))
        fun `ユーザが存在する場合は、Userオブジェクトを返却すること`() {
            val user = userRepository.findByEmail(Email("user1@example.com"))

            Assertions.assertThat(user).isNotNull
        }

        @Test
        @Sql(scripts = ["classpath:sql/test-user-data.sql"], config = SqlConfig(encoding = "utf-8"))
        fun `ユーザが存在しない場合は、nullを返すこと`() {
            val user = userRepository.findByEmail(Email("hogehoge@hoge.com"))
            Assertions.assertThat(user).isNull()
        }
    }

    @Nested
    @DisplayName("insertUserのテスト")
    inner class InsertUserTest() {
        @Test
        fun `DBにレコードが登録されること`() {
            val uuid = UserID.generateUserId()
            val email = Email("sample@example.com")
            val user = User(
                _email = email,
                _userID = uuid,
                _havingRoleList = UserHavingRoleList()
            )
            userRepository.insertUser(user)

            val registeredUser = userRepository.findByEmail(email)

            Assertions.assertThat(registeredUser).isNotNull
            Assertions.assertThat(registeredUser?.email).isEqualTo(email)
            Assertions.assertThat(registeredUser?.userId).isEqualTo(uuid)

        }
    }
}