package com.delier.account.dao;

import com.delier.base.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account,Long> {
}
