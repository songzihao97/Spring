package com.szh.test;

import com.szh.domain.Account;
import com.szh.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService as;


    @Test
    public void testFindAll() {
        //执行方法
        List<Account> Accounts = as.findAllAccount();
        for (Account account : Accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer() {
        as.transfer("aaa","bbb",100);
        //执行方法
        List<Account> Accounts = as.findAllAccount();
        for (Account account : Accounts) {
            System.out.println(account);
        }
    }
}
