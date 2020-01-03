package com.alchen.demo.spring.anno.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 主配置类
 */
//@Configuration
@ComponentScan("com.alchen.demo.spring.anno")
@Import(JdbcConfig.class)
public class SpringConfiguration {


}
