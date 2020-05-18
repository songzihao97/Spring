package com.szh.test;

import com.szh.domain.Account;
import com.szh.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试
 */
public class AccountServiceTest {
    private ApplicationContext ac;
    private AccountService as;

    @Before
    public void init(){
        //获取容器
        ac=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        as = ac.getBean("accountService", AccountService.class);
    }

    @Test
    public void testFindAll() {
        //执行方法
        List<Account> Accounts = as.findAllAccount();
        for (Account account : Accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = as.findById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //3.执行方法
        Account account = as.findById(4);
        account.setMoney(234798);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(4);
    }
}
