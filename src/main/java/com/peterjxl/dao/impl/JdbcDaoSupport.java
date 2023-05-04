package com.peterjxl.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 此类用于抽取dao中的重复代码
 */
public class JdbcDaoSupport {

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        if (this.dataSource == null) {
            this.dataSource = dataSource;
            this.jdbcTemplate = createJdbcTemplate(dataSource);
        }
    }

    private JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
