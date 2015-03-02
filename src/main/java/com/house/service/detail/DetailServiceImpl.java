package com.house.service.detail;

import com.house.api.commons.base.BaseServiceImpl;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Detail;
import com.house.api.service.detail.DetailService;
import com.house.mapper.detail.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户信息接口实现
 * @author liuhaiming
 */
@Service
public class DetailServiceImpl extends BaseServiceImpl<Detail> implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Override
    protected void initBaseMapper() {
        setBaseMapper(detailMapper);
    }


    @Override
    public List<Map<String, String>> getStyleList(PageVo<Detail> vo) throws Exception {
        return detailMapper.getStyleList(vo);
    }

    @Override
    public Long getStyleCount(Detail detail) throws Exception {
        return detailMapper.getStyleCount(detail);
    }
}
