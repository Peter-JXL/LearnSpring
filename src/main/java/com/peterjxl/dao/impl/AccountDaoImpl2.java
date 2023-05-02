package com.peterjxl.dao.impl;

import com.peterjxl.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public AccountDaoImpl2() {
        System.out.println("AccountDaoImpl2对象创建了");
    }
    @Override
    public void saveAccount() {
        System.out.println("保存了账户2222");
    }
}
