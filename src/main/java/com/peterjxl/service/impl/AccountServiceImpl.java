package com.peterjxl.service.impl;

import com.peterjxl.dao.IAccountDao;
import com.peterjxl.domain.Account;
import com.peterjxl.service.IAccountService;
import com.peterjxl.utils.TransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        List<Account> accounts = accountDao.findAllAccount();
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
        //int i = 1 / 0;
        // 2.6 更新转入账户
        accountDao.updateAccount(target);
    }
}
