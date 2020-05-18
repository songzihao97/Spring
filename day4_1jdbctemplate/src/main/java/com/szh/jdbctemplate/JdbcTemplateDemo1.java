package com.szh.jdbctemplate;

import com.szh.dao.AccountDao;
import com.szh.daomain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * jdbcTemplate基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //获取jt
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        //操作
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
}
