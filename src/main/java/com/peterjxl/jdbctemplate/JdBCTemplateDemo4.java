package com.peterjxl.jdbctemplate;

import com.peterjxl.dao.IAccountDao;
import com.peterjxl.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的最基本用法
 */
public class JdBCTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
}
