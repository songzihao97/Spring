package com.szh.factory;

import com.szh.service.AccountService;
import com.szh.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 用于创建Service的代理类对象
 */
public class BeanFactory {

    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    private TransactionManager txManager;

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    //获取service的代理对象
    public AccountService getAccountService(){
       return(AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        try {
                            //开启事务
                            txManager.beginTransaction();
                            //执行操作
                            rtValue=method.invoke(accountService,args);
                            //提交事务
                            txManager.commit();
                            //返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //错误回滚
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            txManager.release();
                        }
                    }
                });
    }
}
