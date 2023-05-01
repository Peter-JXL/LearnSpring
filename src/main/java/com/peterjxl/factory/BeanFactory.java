package com.peterjxl.factory;

import java.util.*;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中，有可重用组件的含义
 * JavaBean：用Java语言编写的可重用组件
 *     javabean > 实体类
 *     它就是创建我们的service和dao对象的
 *
 *     第一个：需要一个配置文件来配置我们的service和dao
 *        配置的内容：唯一标识=全限定类名（key=value）
 *     第二个：通过读取配置文件中配置的内容，反射创建对象
 *     配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    private static Properties props;

    // 定义一个map，用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String, Object> beans;

    // 使用静态代码块为Properties对象赋值
    static {
        props = new Properties();
        try {
            props.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            beans = new HashMap<>();
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()){
                // 取出每个key
                String key = keys.nextElement().toString();

                // 根据key获取value
                String beanPath = props.getProperty(key);

                // 反射创建对象
                Object value = Class.forName(beanPath).newInstance();

                // 把key和value存入容器中
                beans.put(key, value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName){
        Object bean = null;

        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
