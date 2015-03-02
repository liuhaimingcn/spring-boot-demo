package com.house.controller.special;

import com.house.api.commons.base.BaseController;
import com.house.api.commons.base.PageVo;
import com.house.api.commons.base.ResponseVo;
import com.house.api.constant.ConstantType;
import com.house.api.model.Detail;
import com.house.api.model.Special;
import com.house.api.service.detail.DetailService;
import com.house.api.service.special.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuhaiming
 */
@Controller
@RequestMapping("/specials")
public class SpecialController extends BaseController {

    @Autowired
    private SpecialService specialService;

    /**
     * 分页条件查询主题信息
     * @param special 主题条件
     * @param vo 分页信息
     * @return 主题信息
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo index(Special special, PageVo<Special> vo) throws Exception {
        vo.setEntity(special);
        vo.setList(specialService.getSpecialList(vo));
        vo.setSum(specialService.getSpecialCount(special));
        return new ResponseVo(vo);
    }

    /**
     * 根据主键查询对应的专题详情
     * @param id 主键
     * @return 专题详情信息
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo getById(@PathVariable("id") String id, Special special, PageVo<Special> vo) throws Exception {
        special.setId(id);
        vo.setEntity(special);
        vo.setList(specialService.getDetailList(vo));
        vo.setSum(specialService.getDetailCount(special));
        return new ResponseVo(vo);
    }


}
