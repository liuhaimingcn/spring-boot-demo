package com.house.controller.single;

import com.house.api.commons.base.BaseController;
import com.house.api.commons.base.PageVo;
import com.house.api.commons.base.ResponseVo;
import com.house.api.model.Single;
import com.house.api.service.single.SingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuhaiming
 */
@Controller
@RequestMapping("/singles")
public class SingleController extends BaseController {

    @Autowired
    private SingleService singleService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo index(Single single, PageVo<Single> vo) throws Exception {
        vo.setEntity(single);
        vo.setList(singleService.getSingleList(vo));
        vo.setSum(singleService.getSingleCount(single));
        return new ResponseVo(vo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo getById(@PathVariable("id") String id, Single single, PageVo<Single> vo) throws Exception {
        single.setId(id);
        vo.setEntity(single);
        vo.setList(singleService.getDetailList(vo));
        vo.setSum(singleService.getDetailCount(single));
        return new ResponseVo(vo);
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseVo save(@RequestBody Single single) throws Exception {
        singleService.add(single);
        return new ResponseVo();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseVo update(@RequestBody Single single) throws Exception {
        singleService.modify(single);
        return new ResponseVo();
    }


}
