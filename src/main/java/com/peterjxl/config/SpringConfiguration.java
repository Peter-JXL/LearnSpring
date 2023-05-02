package com.peterjxl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 * Configuration
 *     作用：指定当前类是一个配置类
 *
 * ComponentScan
 *    作用：用于通过注解指定spring在创建容器时要扫描的包
 *    属性：
 *    value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包
 */

@Configuration
@ComponentScan("com.peterjxl")
@Import(JdbcConfig.class)
public class SpringConfiguration {

}
