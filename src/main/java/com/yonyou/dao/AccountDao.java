package com.yonyou.dao;

import com.yonyou.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountDao {
    //@Select("select * from tbl_account")

    public List<Account> findAll();
    public List<Account> findById(int id);
    public int insert(Account account);

    public int deleteById(int id);

    public int update(Account account);
    public List<Account> findByName(String name);
}
