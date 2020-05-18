package com.szh.service.impl;

import com.szh.dao.impl.AccountDaoImpl;
import com.szh.daomain.Account;
import com.szh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDaoImpl accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        Account account = accountDao.findAccountById(accountId);
        return account;
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //获取转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //获取转入账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //转出操作
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        //转入操作
        targetAccount.setMoney(targetAccount.getMoney()+money);
        //更新转出账户
        accountDao.updateAccount(sourceAccount);
        //更新转入账户
        accountDao.updateAccount(targetAccount);

    }
}
