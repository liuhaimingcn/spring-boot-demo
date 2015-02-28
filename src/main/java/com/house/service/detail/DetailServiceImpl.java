package com.house.service.detail;

import com.house.api.commons.base.BaseServiceImpl;
import com.house.api.model.Detail;
import com.house.api.service.detail.DetailService;
import com.house.mapper.detail.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
