package com.peterjxl.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();

        // 创建一个代理对象
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object obj,
                                    Method method,
                                    Object[] args,
                                    MethodProxy proxy) throws Throwable {
                //1.获取方法执行的参数
                Float money = (Float) args[0];

                //2.判断当前方法是不是销售，是则抽取20%的提成，否则不抽取
                if ("saleProduct".equals(method.getName())) {
                    return method.invoke(producer, money * 0.8f);
                } else {
                    return method.invoke(producer, money);
                }
            }
        });

        cglibProducer.saleProduct(10000f);
    }
}
