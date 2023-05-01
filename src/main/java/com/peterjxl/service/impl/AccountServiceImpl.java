package com.peterjxl.service.impl;

import com.peterjxl.dao.IAccountDao;
import com.peterjxl.dao.impl.AccountDaoImpl;
import com.peterjxl.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(String name) {
        System.out.println("对象创建了");
    }
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
