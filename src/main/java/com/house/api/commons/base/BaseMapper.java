package com.house.api.commons.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Foghost
 */
public interface BaseMapper<T extends BaseModel> {

    public T getById(Long id) throws Exception;

    public Long getCount(@Param("entity") T entity) throws Exception;

    public List<T> getList(PageVo<T> vo) throws Exception;

    public void modify(T entity) throws Exception;

    public void delete(Long id) throws Exception;

    public void add(T entity) throws Exception;

    public T getById(String id) throws Exception;

    public void delete(String id) throws Exception;
}
