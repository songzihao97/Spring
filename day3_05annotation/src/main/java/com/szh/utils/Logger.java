package com.szh.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，提供公共代码
 */
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.szh.service.impl.*.*(..))")
    private void pt1(){};

    /**
     * 前置通知
     */
    @Before("pt1()")
    private void beforePrintLog(){
        System.out.println("前置logger类中的beforePrintLog开始打印");
    }
    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    private void afterReturnPrintLog(){
        System.out.println("后置logger类中的afterReturnPrintLog开始打印");
    }
    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    private void afterThrowPrintLog(){
        System.out.println("异常logger类中的afterThrowPrintLog开始打印");
    }
    /**
     * 最终通知
     */
    @After("pt1()")
    private void afterPrintLog(){
        System.out.println("最终logger类中的afterPrintLog开始打印");
    }

    /**
     * 环绕通知
     */
   // @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();

            System.out.println("前置logger类中的beforePrintLog开始打印");

            rtValue=pjp.proceed(args);

            System.out.println("后置logger类中的afterReturnPrintLog开始打印");

            return rtValue;
        } catch (Throwable t) {
            System.out.println("异常logger类中的afterThrowPrintLog开始打印");

            throw new RuntimeException();

        }finally {
            System.out.println("最终logger类中的afterPrintLog开始打印");
        }
    }

}
