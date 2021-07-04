import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.arenagod.gradle.MybatisGenerator") version "1.4"
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
}

group = "com.tokorogadokkoi.kotlin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri("https://jitpack.io") }
}

dependencies {
	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	// Spring
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")
	implementation("com.github.guepardoapps:kulid:2.0.0.0")
	// Redis
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.session:spring-session-data-redis")
	// Flyway
	implementation("org.flywaydb:flyway-core")
	// MyBatis
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
	mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0")
	implementation("mysql:mysql-connector-java")
	// Development
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.2.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

mybatisGenerator {
	verbose = true
	overwrite = true
	configFile= "${projectDir}/src/main/resources/mybatis/generatorConfig.xml"

	dependencies {
		mybatisGenerator("mysql:mysql-connector-java")
	}
}