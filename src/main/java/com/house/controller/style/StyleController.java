package com.house.controller.style;

import com.house.api.commons.base.BaseController;
import com.house.api.commons.base.PageVo;
import com.house.api.commons.base.ResponseVo;
import com.house.api.constant.ConstantType;
import com.house.api.model.Detail;
import com.house.api.service.detail.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuhaiming
 */
@Controller
@RequestMapping("/styles")
public class StyleController extends BaseController {

    @Autowired
    private DetailService detailService;

    /**
     * 分页条件查询所有风格信息
     *
     * @param detail 风格条件
     * @param vo     分页条件
     * @return 风格信息
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseVo index(Detail detail, PageVo<Detail> vo) throws Exception {
        // 查询风格的详细
        detail.setType(ConstantType.DETAIL_STYLE);

        vo.setEntity(detail);
        vo.setList(detailService.getStyleList(vo));
        vo.setSum(detailService.getStyleCount(detail));
        return new ResponseVo(vo);
    }


}
