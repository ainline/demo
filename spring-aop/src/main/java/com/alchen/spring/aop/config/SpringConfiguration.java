package com.alchen.spring.aop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 主配置类
 */
//@Configuration
@ComponentScan("com.alchen.demo.spring.aop")
@EnableAspectJAutoProxy
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
