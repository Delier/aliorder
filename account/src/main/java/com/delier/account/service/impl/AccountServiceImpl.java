package com.delier.account.service.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.delier.account.client.ShopClient;
import com.delier.account.dao.AccountDao;
import com.delier.account.service.AccountService;
import com.delier.base.pojo.Account;
import com.delier.base.pojo.Order;
import com.delier.base.util.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    ShopClient shopClient;

    @Override
    public Account getAccount(Long aId) {
        Optional<Account> accountOpt = accountDao.findById(aId);
        return accountOpt.get();
    }

    @Override
    public Boolean consume(Long aId,Long oId) {
        Order order = shopClient.getOrder(oId);
        Account account = accountDao.findById(aId).get();
        BigDecimal money = account.getMoney();
        BigDecimal finalPrice = order.getFinalPrice();
        account.setMoney(money.subtract(finalPrice));
        accountDao.saveAndFlush(account);
        shopClient.updateOrder(oId, Phase.DEAL);
        return Boolean.TRUE;
    }


    @Override
    public Boolean rechargeAmount(Long aId,Long oId) {
        return Boolean.TRUE;
    }
}
