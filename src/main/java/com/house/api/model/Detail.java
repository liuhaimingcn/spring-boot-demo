package com.house.api.model;

import com.house.api.commons.base.BaseModel;

/**
 * @author liuhaiming
 */
public class Detail extends BaseModel{

    private static final long serialVersionUID = 131853464024414923L;
    /**
     * 标题
     */
    private String title;

    /**
     * 简介≤
     */
    private String introduce;

    /**
     * 主照片
     */
    private String picture;

    /**
     * 内容
     */
    private String photos;

    /**
     * 类型（0：专题，1：风格）
     */
    private Integer type;

    /**
     * 风格类型
     */
    private Integer styleType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStyleType() {
        return styleType;
    }

    public void setStyleType(Integer styleType) {
        this.styleType = styleType;
    }
}