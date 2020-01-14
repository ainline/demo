package com.alchen.spring.aopanno.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.alchen.spring.aopanno")
@EnableAspectJAutoProxy //配置类开启注解AOP配置
public class SpringConfiguration {
}
