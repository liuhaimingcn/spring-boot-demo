package com.house.mapper.special;

import com.house.api.commons.base.BaseMapper;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Special;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuhaiming
 */
public interface SpecialMapper extends BaseMapper<Special> {

    /**
     * 分页条件查询主题列表
     * @param vo 分页条件
     * @return 主题信息
     * @throws Exception
     */
    public List<Special> getSpecialList(PageVo<Special> vo) throws Exception;

    /**
     * 条件查询主题总数
     * @param special 主题条件
     * @return 主题信息
     * @throws Exception
     */
    public Long getSpecialCount(Special special) throws Exception;

    /**
     * 分页条件查询某个专题内得详情
     * @param vo 分页条件
     * @return 详情
     * @throws Exception
     */
    public Special getDetailList(PageVo<Special> vo) throws Exception;

    /**
     * 条件查询某个专题内得详情总数
     * @param special 分页详情
     * @return 详情
     * @throws Exception
     */
    public Long getDetailCount(@Param("entity") Special special) throws Exception;
}