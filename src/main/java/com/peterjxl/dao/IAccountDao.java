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

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一的结果就返回，如果没有结果就返回 null
     * 如果结果集超过一个就抛异常
     */
    Account findAccountByName(String accountName);
}
