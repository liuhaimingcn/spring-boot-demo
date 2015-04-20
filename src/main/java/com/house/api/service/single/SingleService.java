package com.house.api.service.single;


import com.house.api.commons.base.BaseService;
import com.house.api.commons.base.PageVo;
import com.house.api.model.Single;
import com.house.api.model.Special;

import java.util.List;

/**
 * @author liuhaiming
 */
public interface SingleService extends BaseService<Single> {

    public List<Single> getSingleList(PageVo<Single> vo) throws Exception;

    public Long getSingleCount(Single single) throws Exception;

    public Single getDetailList(PageVo<Single> vo) throws Exception;

    public Long getDetailCount(Single single) throws Exception;
}
