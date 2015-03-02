package com.house.mapper.detail;

import com.house.api.commons.base.BaseMapper;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author liuhaiming
 */
public interface DetailMapper extends BaseMapper<Detail> {

    /**
     * 分页条件查询风格详情
     * @param vo 分页条件
     * @return  风格详情
     * @throws Exception
     */
    public List<Map<String, String>> getStyleList(PageVo<Detail> vo) throws Exception;

    /**
     * 条件查询详情总数
     * @param detail 条件
     * @return 总数
     * @throws Exception
     */
    public Long getStyleCount(@Param("entity") Detail detail) throws Exception;
}