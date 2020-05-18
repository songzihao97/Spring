package com.szh.ui;

import com.szh.dao.AccountDao;
import com.szh.service.AccountService;
import com.szh.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 模拟表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取Spring的ioc核心容器，并根据id获取对象
     * ApplicationContext的三个实现类
     *   ClassPathXMLApplicationContext:类路径下的配置文件
     *   FileSystemXmlApplicationContext:加载磁盘内文件
     *   AnnotationConfigApplicationContext:读取注解创建容器
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        System.out.println(as);
        System.out.println(accountDao);
    }
}
