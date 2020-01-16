package com.alchen.spring.jdbctemplate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

@Configuration
@ComponentScan(basePackages = "com.alchen.spring")
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
