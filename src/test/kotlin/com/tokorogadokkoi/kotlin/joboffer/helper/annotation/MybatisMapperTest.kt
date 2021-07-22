package com.tokorogadokkoi.kotlin.joboffer.helper.annotation

import com.tokorogadokkoi.kotlin.joboffer.config.mybatis.PropertyHolder
import com.tokorogadokkoi.kotlin.joboffer.config.mybatis.SqlSessionFactory
import org.junit.jupiter.api.extension.ExtendWith
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@ExtendWith(SpringExtension::class)
@MybatisTest
@Transactional
@AutoConfigureTestDatabase(
    replace = AutoConfigureTestDatabase.Replace.NONE
)
@Import(value = [PropertyHolder::class, SqlSessionFactory::class])
annotation class MybatisMapperTest()
