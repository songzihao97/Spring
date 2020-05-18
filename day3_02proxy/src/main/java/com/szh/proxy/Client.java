package com.szh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {

        Producer producer=new Producer();

        /**
         * 基于接口的动态代理
         *  proxy : 来源JDK
         */
        IProducer proxyProducer =(IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), Producer.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object returnValue=null;

                Float money=(Float) args[0];

                if ("saleProduct".equals(method.getName())){
                  returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });

        proxyProducer.saleProduct(10000f);
    }
}
