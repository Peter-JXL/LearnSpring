package com.peterjxl.dao.impl;

import com.peterjxl.dao.IAccountDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 账户的持久层实现类
 */

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }

    @PostConstruct
    public void init() {
        System.out.println("对象初始化了");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("对象销毁了");
    }
}
