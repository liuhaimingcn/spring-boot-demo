package com.house.controller.detail;

import com.house.api.commons.base.BaseController;
import com.house.api.commons.base.PageVo;
import com.house.api.commons.base.ResponseVo;
import com.house.api.model.Detail;
import com.house.api.model.Special;
import com.house.api.service.detail.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuhaiming
 */
@Controller
@RequestMapping("/details")
public class DetailController extends BaseController {

    @Autowired
    private DetailService detailService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo index(Detail detail, PageVo<Detail> vo) throws Exception {
        vo.setEntity(detail);
        vo.setList(detailService.getList(vo));
        vo.setSum(detailService.getCount(detail));
        return new ResponseVo(vo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseVo modify(@RequestBody Detail detail) throws Exception {
        detailService.modify(detail);
        return new ResponseVo();
    }


    /**
     * 添加详情
     *
     * @param detail 详情内容
     * @return 成功信息
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseVo save(@RequestBody Detail detail) throws Exception {
        detailService.add(detail);
        return new ResponseVo();
    }

    /**
     * 根据主键查询对应的详情
     * @param id 主键
     * @return 详情信息
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo getById(@PathVariable("id") String id) throws Exception {
        return new ResponseVo(detailService.getById(id));
    }

}
