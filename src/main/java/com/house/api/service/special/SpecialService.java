package com.house.api.service.special;


import com.house.api.commons.base.BaseService;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Detail;
import com.house.api.model.Special;

import java.util.List;
import java.util.Map;

/**
 * @author liuhaiming
 */
public interface SpecialService extends BaseService<Special> {

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
    public Long getDetailCount(Special special) throws Exception;
}
