package com.peterjxl.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，它包含了开启事务，提交事务，回滚事务和释放连接
 */

@Component("transactionManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.peterjxl.service.impl.*.*(..))")
    private void pt1() {}
    /**
     * 开启事务
     */

    @Before("pt1()")
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    //@AfterReturning("pt1()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
    //@AfterThrowing("pt1()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放连接
     */
    //@After("pt1()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close(); // 还回连接池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            // 1. 获取参数
            Object[] args = pjp.getArgs();
            // 2. 开启事务
            this.beginTransaction();
            // 3. 执行方法
            rtValue = pjp.proceed(args);
            // 4. 提交事务
            this.commit();
            // 5. 返回结果
            return rtValue;
        } catch (Throwable e) {
            // 6. 回滚事务
            this.rollback();
            throw new RuntimeException(e);
        } finally {
            // 7. 释放资源
            this.release();
        }
    }
}
