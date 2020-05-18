package com.szh.test;


import com.szh.config.SpringConfiguration;
import com.szh.daomain.Account;
import com.szh.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService ac;

    @Test
    public void testFindById(){
        Account account = ac.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testTransfer(){
        ac.transfer("aaa","bbb",100f);
    }

}
