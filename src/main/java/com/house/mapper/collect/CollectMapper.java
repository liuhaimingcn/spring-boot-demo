package com.house.mapper.collect;

import com.house.api.commons.base.BaseMapper;
import com.house.api.model.Collect;

/**
 * @author liuhaiming
 */
public interface CollectMapper extends BaseMapper<Collect> {

    public Collect getByAcoountIdAndDetailId(Collect collect) throws Exception;
}