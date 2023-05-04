package com.peterjxl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 */

@Configuration
@ComponentScan("com.peterjxl")
@Import({JdbcConfig.class,TransactionConfig.class})
@EnableTransactionManagement
public class SpringConfiguration {

}
