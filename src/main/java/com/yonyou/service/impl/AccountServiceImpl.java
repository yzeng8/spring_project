package com.yonyou.service.impl;

import com.yonyou.dao.AccountDao;
import com.yonyou.domain.Account;
import com.yonyou.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public List<Account> findById(int id) {
        return accountDao.findById(id);
    }

    public int insert(Account account) {

        return accountDao.insert(account);
    }

    public int deleteById(int id) {
        return accountDao.deleteById(id);
    }

    public int updateAccount(Account account) {
        return accountDao.update(account);
    }

    public List<Account> findByName(String name) {
        return accountDao.findByName(name);
    }

}
