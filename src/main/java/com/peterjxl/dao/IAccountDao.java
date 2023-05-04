package com.peterjxl.dao;

import com.peterjxl.domain.Account;

public interface IAccountDao {

    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);


    /**
     * 根据名称查询账户信息
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);
}
