package com.tokorogadokkoi.kotlin.joboffer.config.mybatis

import org.apache.ibatis.datasource.pooled.PooledDataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import javax.sql.DataSource
import kotlin.jvm.Throws

@Configuration
@MapperScan(
    basePackages = [
        "com.tokorogadokkoi.kotlin.joboffer.auth.mysql.mapper"
    ],
    sqlSessionTemplateRef = "SqlSessionTemplate"
)
class SqlSessionFactory(private val propertyHolder: PropertyHolder) {

    // DataSource
    @Bean(name = ["DataSource"])
    @ConfigurationProperties(prefix = "spring.datasource")
    fun dataSource(): DataSource? {
        return PooledDataSource().apply {
            url = propertyHolder.url
            username = propertyHolder.username
            password = propertyHolder.password
            driver = propertyHolder.driverClassName
        }
    }

    // Sql Session Factory
    @Bean(name = ["SqlSessionFactory"])
    @Throws(Exception::class)
    fun sqlSessionFactory(@Qualifier("DataSource") dataSource: DataSource?): SqlSessionFactory? {
        val bean = SqlSessionFactoryBean()
        bean.setDataSource(dataSource)
        bean.setConfigLocation(ClassPathResource("mybatis/mybatis-config.xml"))

        return bean.`object`
    }

    // Sql Session Template
    @Bean(name = ["SqlSessionTemplate"])
    @Throws(java.lang.Exception::class)
    fun sqlSessionTemplate(@Qualifier("SqlSessionFactory") sqlSessionFactory: SqlSessionFactory): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}