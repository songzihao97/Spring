package com.szh.ui;

import com.szh.dao.AccountDao;
import com.szh.service.AccountService;
import com.szh.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 模拟表现层，用于调用业务层
 */
public class Client {


    public static void main(String[] args) {
        //获取核心容器
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        System.out.println(as);
        as.saveAccount();
        ac.close();

    }
}
