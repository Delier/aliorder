package com.delier.account.controller;

import com.delier.account.service.AccountService;
import com.delier.base.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/info/{id}")
    public void getAccount(@PathVariable("id") Long aId){
        Account account = accountService.getAccount(aId);
    }

    // TODO: 2023/11/1 修改当前用户的获取方式
    @PutMapping("/consume/{aId}/{oId}")
    public void consume(@PathVariable("aId") Long aId,@PathVariable("oId") Long oId){
        accountService.consume(aId,oId);
    }

}
