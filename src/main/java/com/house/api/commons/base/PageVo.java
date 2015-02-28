package com.house.api.commons.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @author wenfeng zhang @ 14-10-10
 */
public class PageVo<T extends BaseModel> implements Serializable {

    private static final long serialVersionUID = 3144038956308932204L;

    private static final int DEFAULT_PAGE_SIZE = 12;
    public static final int PAGING_YES = 1;
    public static final int PAGING_NO = 0;

    /**
     * 分页时的第几页
     */
    private Integer page = 1;
    /**
     * 每页数目，默认为 DEFAULT_PAGE_SIZE
     */
    private Integer size = DEFAULT_PAGE_SIZE;
    /**
     * 查询结果总数
     */
    private Long sum;
    /**
     * 是否分页，默认是
     */
    @JsonIgnore
    private Integer isPaging = PAGING_YES;
    /**
     * 查询参数
     */
    @JsonIgnore
    private T entity;

    private Object list;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Integer getIsPaging() {
        return isPaging;
    }

    public void setIsPaging(Integer isPaging) {
        this.isPaging = isPaging;
    }

    @JsonIgnore
    public Long getFrom() {
        return size.longValue() * (page - 1);
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }
}
