package com.peterjxl.factory;

import com.peterjxl.service.IAccountService;
import com.peterjxl.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    // 用来注入，需要set方法
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取service的代理对象
     *
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            // 1. 开启事务
                            txManager.beginTransaction();
                            // 2. 执行操作
                            rtValue = method.invoke(accountService, args);
                            //3. 提交事务
                            txManager.commit();
                            //4. 返回结果
                            return rtValue;
                        } catch (Exception e) {
                            // 5. 回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            // 6. 释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
