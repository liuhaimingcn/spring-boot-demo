package com.house.service.single;

import com.house.api.commons.base.BaseServiceImpl;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Single;
import com.house.api.model.Special;
import com.house.api.service.single.SingleService;
import com.house.api.service.special.SpecialService;
import com.house.mapper.single.SingleMapper;
import com.house.mapper.special.SpecialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhaiming
 */
@Service
public class SingleServiceImpl extends BaseServiceImpl<Single> implements SingleService {

    @Autowired
    private SingleMapper singleMapper;

    @Override
    protected void initBaseMapper() {
        setBaseMapper(singleMapper);
    }

    @Override
    public List<Single> getSingleList(PageVo<Single> vo) throws Exception {
        return singleMapper.getSingleList(vo);
    }

    @Override
    public Long getSingleCount(Single single) throws Exception {
        return singleMapper.getSingleCount(single);
    }

    @Override
    public Single getDetailList(PageVo<Single> vo) throws Exception {
        return singleMapper.getDetailList(vo);
    }

    @Override
    public Long getDetailCount(Single single) throws Exception {
        return singleMapper.getDetailCount(single);
    }
}
