package com.peterjxl.dao.impl;

import com.peterjxl.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */

@Repository("accountDao3")
public class AccountDaoImpl3 implements IAccountDao {

    public AccountDaoImpl3() {
        System.out.println("AccountDaoImpl3对象创建了");
    }
    @Override
    public void saveAccount() {
        System.out.println("保存了账户3333");
    }
}
