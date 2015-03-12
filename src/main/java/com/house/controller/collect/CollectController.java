package com.house.controller.collect;

import com.house.api.commons.base.BaseController;
import com.house.api.commons.base.PageVo;
import com.house.api.commons.base.ResponseVo;
import com.house.api.exception.NoticeException;
import com.house.api.model.Account;
import com.house.api.model.Collect;
import com.house.api.model.Special;
import com.house.api.service.account.AccountService;
import com.house.api.service.collect.CollectService;
import com.house.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author liuhaiming
 */
@Controller
@RequestMapping("/collects")
public class CollectController extends BaseController {

    @Autowired
    private CollectService collectService;

    /**
     * 分页条件查询收藏信息
     * @param collect 收藏的条件
     * @param vo 分页条件
     * @return 收藏信息
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo index(Collect collect, PageVo<Collect> vo) throws Exception {
        vo.setEntity(collect);
        vo.setList(collectService.getList(vo));
        vo.setSum(collectService.getCount(collect));
        return new ResponseVo(vo);
    }

    /**
     * 添加收藏
     * @param collect 收藏信息
     * @return 成功信息
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseVo save(@RequestBody Collect collect) throws Exception {
        // 收藏过的不能再被收藏
        Collect newCollect = collectService.getByAcoountIdAndDetailId(collect);
        if (newCollect == null) {
            collectService.add(collect);
        } else {
            throw new NoticeException("您已经收藏过了!");
        }

        return new ResponseVo();
    }

}
