package com.house.mapper.single;

import com.house.api.commons.base.BaseMapper;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Single;
import com.house.api.model.Special;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuhaiming
 */
public interface SingleMapper extends BaseMapper<Single> {

    public List<Single> getSingleList(PageVo<Single> vo) throws Exception;

    public Long getSingleCount(Single single) throws Exception;


    public Single getDetailList(PageVo<Single> vo) throws Exception;

    public Long getDetailCount(@Param("entity") Single single) throws Exception;
}