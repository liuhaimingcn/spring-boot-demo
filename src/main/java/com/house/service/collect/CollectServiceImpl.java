package com.house.service.collect;

import com.house.api.commons.base.BaseServiceImpl;
import com.house.api.model.Account;
import com.house.api.model.Collect;
import com.house.api.service.account.AccountService;
import com.house.api.service.collect.CollectService;
import com.house.mapper.account.AccountMapper;
import com.house.mapper.collect.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhaiming
 */
@Service
public class CollectServiceImpl extends BaseServiceImpl<Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    protected void initBaseMapper() {
        setBaseMapper(collectMapper);
    }


    @Override
    public Collect getByAcoountIdAndDetailId(Collect collect) throws Exception {
        return collectMapper.getByAcoountIdAndDetailId(collect);
    }
}
