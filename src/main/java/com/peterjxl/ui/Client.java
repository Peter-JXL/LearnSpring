package com.peterjxl.ui;

import com.peterjxl.dao.IAccountDao;
import com.peterjxl.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService)ac.getBean("accountService");
        as.saveAccount();
    }
}
