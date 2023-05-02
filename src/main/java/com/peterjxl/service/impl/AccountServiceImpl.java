package com.peterjxl.service.impl;


import com.peterjxl.dao.IAccountDao;
import com.peterjxl.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao3")
    @Resource(name = "accountDao3")
    private IAccountDao accountDao2;

    @Override
    public void saveAccount() {
        accountDao2.saveAccount();
    }
}
