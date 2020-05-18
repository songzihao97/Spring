package com.szh.service.impl;

import com.szh.dao.AccountDao;
import com.szh.domain.Account;
import com.szh.service.AccountService;
import com.szh.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl_OLD implements AccountService {

    private AccountDao accountDao;

    private TransactionManager txManager;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //提交事务
            txManager.commit();
            //返回结果
            return accounts;
        } catch (Exception e) {
            //错误回滚
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放资源
            txManager.release();
        }
    }

    @Override
    public Account findById(Integer id) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            Account account = accountDao.findById(id);
            //提交事务
            txManager.commit();
            //返回结果
            return account;
        } catch (Exception e) {
            //错误回滚
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.saveAccount(account);
            //提交事务
            txManager.commit();
        } catch (Exception e) {
            //错误回滚
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.updateAccount(account);
            //提交事务
            txManager.commit();
        } catch (Exception e) {
            //错误回滚
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
            accountDao.deleteAccount(id);
            //提交事务
            txManager.commit();
        } catch (Exception e) {
            //错误回滚
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }

    }

    @Override
    public void transfer(String sourceName, String targetName, double money) {
        try {
            //开启事务
            txManager.beginTransaction();
            //执行操作
                //根据名称查询转出账户
                Account source = accountDao.findByName(sourceName);
                //根据名称查询转入账户
                Account target = accountDao.findByName(targetName);
                //转出账户减钱
                source.setMoney(source.getMoney()-money);
                //转入账户加钱
                target.setMoney(target.getMoney()+money);
                //更新转出账户
                accountDao.updateAccount(source);
                //更新转入账户
                accountDao.updateAccount(target);
            //提交事务
            txManager.commit();
        } catch (Exception e) {
            //错误回滚
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }

    }


}
