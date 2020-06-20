package com.firefly.service.impl;

import com.firefly.dao.AccountDao;
import com.firefly.domain.Account;
import com.firefly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountservice")
public class AccoutServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层的查询所有方法执行了...");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层的保存账户方法执行了...");
        accountDao.saveAccount(account);

    }
}
