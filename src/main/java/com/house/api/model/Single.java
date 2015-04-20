package com.house.api.model;

import com.house.api.commons.base.BaseModel;

import java.util.List;

/**
 * 单品基本信息
 *
 * @author liuhaiming
 */
public class Single extends BaseModel {

    private static final long serialVersionUID = -2020562266006012714L;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情
     */
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


}