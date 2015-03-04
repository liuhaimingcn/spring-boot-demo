package com.house.api.service.account;


import com.house.api.commons.base.BaseService;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Account;
import com.house.api.model.Detail;

import java.util.List;
import java.util.Map;

/**
 * @author liuhaiming
 */
public interface AccountService extends BaseService<Account> {

    /**
     * 添加用户信息
     * @param account 用户信息
     * @throws Exception
     */
    public void addAccount(Account account) throws Exception;
}
