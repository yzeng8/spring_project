package com.yonyou.service;

import com.yonyou.dao.AccountDao;
import com.yonyou.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public Account findById(int id);

    public int insert(Account account);

    public int deleteById(int id);

    public int updateAccount(Account account);
}
