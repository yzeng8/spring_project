package com.yonyou.controller;

import com.yonyou.domain.Account;
import com.yonyou.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class UserController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @GetMapping
    public List<Account> getAccount() {

        List<Account> accounts= accountServiceImpl.findAll();
        return accounts;
    }

    @GetMapping({"/{id}"})
    public Account getAccountById(@PathVariable int id) {
        System.out.println("id->:"+id);
        Account account= accountServiceImpl.findById(id);
        return account;
    }

    @PostMapping
    public String addAccount(@RequestBody Account account) {
        int num_row = accountServiceImpl.insert(account);
        return ("插入成功,"+ num_row);
    }

    @DeleteMapping({"/{id}"})
    public String deleteAccount(@PathVariable int id) {
        System.out.println("id->:"+id);
        int num_row = accountServiceImpl.deleteById(id);
        return "删除成功";
    }

    @PutMapping
    public String updateAccount(@RequestBody Account account) {
        //System.out.println("id->:"+id);
        int num_row = accountServiceImpl.updateAccount(account);
        return "修改成功";
    }
}
