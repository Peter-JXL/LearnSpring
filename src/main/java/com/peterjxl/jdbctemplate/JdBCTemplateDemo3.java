package com.peterjxl.jdbctemplate;

import com.peterjxl.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * JdbcTemplate的增删改查
 */
public class JdBCTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 保存
        jt.update("insert into account(name, money) values(?, ?)", "fff", 1000f);

        //更新
        jt.update("update account set name=?, money=? where id=?", "test", 100f, 7);

        // 删除
        jt.update("delete from account where id=?", 8);

        // 查询所有
        List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(), 1000f);
        List<Account> accounts2 = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<>(Account.class), 1000f);
        for (Account account : accounts) {
            System.out.println(account);
        }
        for (Account account : accounts2) {
            System.out.println(account);
        }


        // 查询一个
        List<Account> accounts1 = jt.query("select * from account where id = ?", new AccountRowMapper(), 1);
        System.out.println(accounts1.isEmpty() ? "没有内容" : accounts1.get(0));

        // 查询返回一行一列（使用聚合函数，但不加group by子句）
        Long count = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {

    /**
     * 把结果集中的数据封装到Account中，然后由Spring把每个Account加到集合中
     */
    public Account mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}