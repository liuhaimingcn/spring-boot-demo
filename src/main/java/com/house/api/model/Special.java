package com.house.api.model;

import com.house.api.commons.base.BaseModel;

import java.util.List;

/**
 * 专题基本信息
 *
 * @author liuhaiming
 */
public class Special extends BaseModel {

    private static final long serialVersionUID = -2020562266006012714L;

    private String title;

    private String introduce;

    private String picture;

    private List<Detail> detailList;

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
}