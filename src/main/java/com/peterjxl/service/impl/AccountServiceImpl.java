package com.peterjxl.service.impl;

import com.peterjxl.dao.IAccountDao;
import com.peterjxl.domain.Account;
import com.peterjxl.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public Account findAccountById(Integer accountId) {
        return transactionTemplate.execute(new TransactionCallback<Account>() {
            @Override
            public Account doInTransaction(TransactionStatus status) {
                return accountDao.findAccountById(accountId);
            }
        });
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                // 2.1 根据名称查询转出账户
                Account source = accountDao.findAccountByName(sourceName);
                // 2.2 根据名称查询转入账户
                Account target = accountDao.findAccountByName(targetName);
                // 2.3 转出账户减钱
                source.setMoney(source.getMoney() - money);
                // 2.4 转入账户加钱
                target.setMoney(target.getMoney() + money);
                // 2.5 更新转出账户
                accountDao.updateAccount(source);

                //int i = 1/0;
                // 2.6 更新转入账户
                accountDao.updateAccount(target);
                return null;
            }
        });
    }
}
