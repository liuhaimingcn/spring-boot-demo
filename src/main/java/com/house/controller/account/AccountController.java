package com.house.controller.account;

import com.house.api.commons.base.BaseController;
import com.house.api.commons.base.ResponseVo;
import com.house.api.constant.ConstantType;
import com.house.api.model.Account;
import com.house.api.model.Detail;
import com.house.api.service.account.AccountService;
import com.house.api.service.detail.DetailService;
import com.house.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author liuhaiming
 */
@Controller
@RequestMapping("/accounts")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 添加用户
     * @param account 用户信息
     * @return 用户的主键
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseVo login(@RequestBody Account account) throws Exception {
        String openId = account.getOpenid();
        // 查询用户是否存在
        Account accountNew = accountService.getAccountByOpenId(openId);
        if (accountNew == null) {
            String id = UUIDUtil.generateUniqueKey();
            account.setId(id);
            account.setCreatedOn(new Date());
            accountService.addAccount(account);
        } else {
            account = accountNew;
        }
        return new ResponseVo(account);
    }

}
