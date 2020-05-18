package com.szh.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        Producer producer=new Producer();

        /**
         * 基于子类的动态代理
         *  Enhancer:；来源cglib库
         *    参数：class
         *          callback：提供增强代码，一般用子接口实现类：MethodInterceptor
         */
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue=null;
                float money=(Float) objects[0];
                if ("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(10000f);
    }
}
