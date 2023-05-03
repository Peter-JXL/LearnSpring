package com.peterjxl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();

        //定义代理对象
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                Producer.class.getInterfaces(),
                new InvocationHandler() {
                    /**
                     * InvocationHandler中只有一个方法，
                     * 它的作用就是：执行被代理对象的任何接口方法都会经过该方法
                     * 方法参数的含义
                     * @param proxy   代理对象的引用
                     * @param method  当前执行的方法
                     * @param args    当前执行方法所需的参数
                     * @return 和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy,
                                         Method method,
                                         Object[] args) throws Throwable {
                        //1.获取方法执行的参数
                        Float money = (Float) args[0];

                        //2.判断当前方法是不是销售，是则抽取20%的提成，否则不抽取
                        if ("saleProduct".equals(method.getName())) {
                            return method.invoke(producer, money * 0.8f);
                        } else {
                            return method.invoke(producer, money);
                            /**
                             * invoke方法的第一个参数：要执行的对象，后续参数：要执行的方法的参数
                             * 匿名内部类访问外部变量，该变量需要是Final修饰符
                             */
                        }
                    }
                });

        proxyProducer.saleProduct(10000f);
    }
}
