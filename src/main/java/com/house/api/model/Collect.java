package com.house.api.model;

import com.house.api.commons.base.BaseModel;

import java.util.List;


/**
 * 收藏信息
 *
 * @author liuhaiming
 */
public class Collect extends BaseModel {
    private static final long serialVersionUID = -6205761753892700490L;

    /**
     * 用户主键
     */
    private String accoutId;

    /**
     * 详情主键
     */
    private String detailId;

    /**
     * 详情信息
     */
    private List<Detail> detailList;

    public String getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(String accoutId) {
        this.accoutId = accoutId == null ? null : accoutId.trim();
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
}