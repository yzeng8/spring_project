package com.yonyou.service;

import com.yonyou.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public List<Account> findById(int id);

    public int insert(Account account);

    public int deleteById(int id);

    public int updateAccount(Account account);
    public List<Account> findByName(String name);
}
