package com.peterjxl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.peterjxl")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
