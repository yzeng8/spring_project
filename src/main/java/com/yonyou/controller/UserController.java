package com.yonyou.controller;

import com.yonyou.domain.Account;
import com.yonyou.exception.BusinessException;
import com.yonyou.exception.SystemException;
import com.yonyou.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class UserController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @GetMapping
    public Map<String,Object> getAccount() {
        //int i = 1/0;  //异常检测
        List<Account> accounts= accountServiceImpl.findAll();
        Map<String,Object> result=new HashMap<>();
        result.put("data",accounts);
        result.put("msg","数据获取成功");
        return result;
    }

    @GetMapping({"/{id}"})
    public Map<String,Object> getAccountById(@PathVariable int id) {
        System.out.println("id->:"+id);
        if (id<1){
            throw new BusinessException(Code.Bussiness_ERR,"数据接受异常！");
        }

            try{


                //int i = 1/0;
                List<Account> accounts= accountServiceImpl.findById(id);
                Map<String,Object> result=new HashMap<>();
                result.put("data",accounts);
                result.put("msg","数据获取成功");
                return result;
            }
            catch (Exception e){
                throw new SystemException(Code.SYSTEM_ERR,"数据输入异常!");
            }



    }

    @PostMapping
    public Map<String,Object> addAccount(@RequestBody Account account) {
        int num_row = accountServiceImpl.insert(account);

        List<Account> accounts= accountServiceImpl.findByName(account.getName());
        Map<String,Object> result=new HashMap<>();
        result.put("data",accounts);
        result.put("msg","数据插入成功,插入数据如下:");
        return result;
    }

    @DeleteMapping({"/{id}"})
    public Map<String,Object> deleteAccount(@PathVariable int id) {
        System.out.println("id->:"+id);
        List<Account> accounts = accountServiceImpl.findById(id);
        int num_row = accountServiceImpl.deleteById(id);
        Map<String,Object> result=new HashMap<>();
        result.put("data",accounts);
        result.put("msg","数据删除成功,插入数据如下:");
        return result;
    }

    @PutMapping
    public Map<String,Object> updateAccount(@RequestBody Account account) {
        //System.out.println("id->:"+id);
        int num_row = accountServiceImpl.updateAccount(account);
        List<Account> accounts= new ArrayList<>();
        accounts.add(account);
        Map<String,Object> result=new HashMap<>();
        result.put("data",accounts);
        result.put("msg","数据修改成功,修改数据如下:");
        return result;
    }
}
