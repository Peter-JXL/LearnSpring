package com.peterjxl.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 */
public class JdBCTemplateDemo1 {
    public static void main(String[] args) {
        // 准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///learnSpring");
        ds.setUsername("learnSpringUser");
        ds.setPassword("learnSpringPassword");

        // 1. 创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate(ds);

        //2. 执行操作
        jt.execute("insert into account(name, money) values('ddd', 1000)");
    }
}
