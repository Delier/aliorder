package com.delier.account.service;

import com.delier.base.pojo.Account;

public interface AccountService {
    //获取账户信息
    Account getAccount(Long aId);
    //消费
    Boolean consume(Long aId,Long oId);
    //充值
    Boolean rechargeAmount(Long aId,Long oId);
}
