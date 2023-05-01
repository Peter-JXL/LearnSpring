package com.peterjxl.service.impl;

import com.peterjxl.dao.IAccountDao;
import com.peterjxl.dao.impl.AccountDaoImpl;
import com.peterjxl.factory.BeanFactory;
import com.peterjxl.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
