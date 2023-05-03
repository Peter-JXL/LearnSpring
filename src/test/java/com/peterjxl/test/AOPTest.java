package com.peterjxl.test;

import com.peterjxl.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP的测试类
 */
public class AOPTest {
    public static void main(String[] args) {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // 3. 执行方法
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
