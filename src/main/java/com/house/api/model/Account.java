package com.house.api.model;

import com.house.api.commons.base.BaseModel;

/**
 * 用户基本信息
 *
 * @author liuhaiming
 */
public class Account extends BaseModel {

    private static final long serialVersionUID = -9105321455640206167L;

    /**
     * 名字
     */
    private String name;

    /**
     * 性别（0：无，1：男，2：女）
     */
    private Integer sex;

    /**
     * 第三方用户id
     */
    private String openid;

    /**
     * 账户的来源
     */
    private Integer accountFrom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Integer accountFrom) {
        this.accountFrom = accountFrom;
    }

}