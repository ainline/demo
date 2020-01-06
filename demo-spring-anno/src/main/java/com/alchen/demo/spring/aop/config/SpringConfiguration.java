package com.alchen.demo.spring.aop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 主配置类
 */
//@Configuration
@ComponentScan("com.alchen.demo.spring.aop")
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
