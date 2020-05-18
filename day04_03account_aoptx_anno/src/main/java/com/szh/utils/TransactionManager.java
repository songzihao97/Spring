package com.szh.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关工具类
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.szh.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务
     */
    //@Before("pt1()")
    public void beginTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
   // @AfterReturning("pt1()")
    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
   // @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
   // @After("pt1()")
    public void release(){
        try {
            connectionUtils.getConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
       Object rtValues=null;
        try {
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtValues=pjp.proceed(args);
            //4.提交事务
            this.commit();
            //返回结果
            return rtValues;
        } catch (Throwable e) {
            //5.异常回滚
            this.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放资源
            this.release();
        }
    }

}
