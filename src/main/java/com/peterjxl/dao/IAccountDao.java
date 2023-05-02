package com.peterjxl.dao;

import com.peterjxl.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
