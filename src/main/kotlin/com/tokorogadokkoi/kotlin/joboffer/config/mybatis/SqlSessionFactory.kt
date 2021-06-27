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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import javax.sql.DataSource
import kotlin.jvm.Throws

@Configuration
@MapperScan(
    basePackages = [
        "com.tokorogadokkoi.kotlin.joboffer.infra.mysql",
    ],
    sqlSessionTemplateRef = "SqlSessionTemplate"
)
class SqlSessionFactory(private val propertyHolder: MyBatisPropertyHolder) {
    companion object {
        const val MAPPER_XML_PATH = "classpath:com/tokorogadokkoi/kotlin/**/mybatis-config.xml"
    }

    @Bean(name = ["DataSource"])
    @ConfigurationProperties(prefix = "spring.datasource")
    fun dataSource(): DataSource? {
        val dataSource =  PooledDataSource()
        dataSource.url = propertyHolder.url
        dataSource.username = propertyHolder.username
        dataSource.password = propertyHolder.password
        dataSource.driver = propertyHolder.driverClassName

        return dataSource
    }

    @Bean(name = ["SqlSessionFactory"])
    @Throws(Exception::class)
    fun sqlSessionFactory(@Qualifier("DataSource") dataSource: DataSource?): SqlSessionFactory? {
        val bean = SqlSessionFactoryBean()
        bean.setDataSource(dataSource)
        bean.setMapperLocations(*PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH))
        return bean.`object`
    }

    @Bean(name = ["SqlSesisonTemplate"])
    @Throws(java.lang.Exception::class)
    fun sqlSessionTemplate(@Qualifier("SqlSessionFactory") sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate? {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}