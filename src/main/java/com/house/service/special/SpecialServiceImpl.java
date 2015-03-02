package com.house.service.special;

import com.house.api.commons.base.BaseServiceImpl;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Detail;
import com.house.api.model.Special;
import com.house.api.service.detail.DetailService;
import com.house.api.service.special.SpecialService;
import com.house.mapper.detail.DetailMapper;
import com.house.mapper.special.SpecialMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liuhaiming
 */
@Service
public class SpecialServiceImpl extends BaseServiceImpl<Special> implements SpecialService {

    @Autowired
    private SpecialMapper specialMapper;

    @Override
    protected void initBaseMapper() {
        setBaseMapper(specialMapper);
    }

    @Override
    public List<Special> getSpecialList(PageVo<Special> vo) throws Exception {
        return specialMapper.getSpecialList(vo);
    }

    @Override
    public Long getSpecialCount(Special special) throws Exception {
        return specialMapper.getSpecialCount(special);
    }

    @Override
    public Special getDetailList(PageVo<Special> vo) throws Exception {
        return specialMapper.getDetailList(vo);
    }

    @Override
    public Long getDetailCount(Special special) throws Exception {
        return specialMapper.getDetailCount(special);
    }
}
