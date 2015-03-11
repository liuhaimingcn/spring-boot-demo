package com.house.service.account;

import com.house.api.commons.base.BaseServiceImpl;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Account;
import com.house.api.model.Detail;
import com.house.api.service.account.AccountService;
import com.house.api.service.detail.DetailService;
import com.house.mapper.account.AccountMapper;
import com.house.mapper.detail.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liuhaiming
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected void initBaseMapper() {
        setBaseMapper(accountMapper);
    }

    @Override
    public void addAccount(Account account) throws Exception {
        accountMapper.add(account);
    }

    @Override
    public Account getAccountByOpenId(String openId) throws Exception {
        return accountMapper.getAccountByOpenId(openId);
    }
}
