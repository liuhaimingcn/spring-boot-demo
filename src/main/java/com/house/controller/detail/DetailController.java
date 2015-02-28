package com.house.controller.detail;

import com.house.api.commons.base.BaseController;
import com.house.api.commons.base.ResponseVo;
import com.house.api.model.Detail;
import com.house.api.service.detail.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author liuhaiming
 */
@Controller
@RequestMapping("/details")
public class DetailController extends BaseController {

    @Autowired
    private DetailService detailService;

    /**
     * 添加详情
     * @param detail 详情内容
     * @return 成功信息
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseVo save(@RequestBody Detail detail) throws Exception {
        detailService.add(detail);
        return new ResponseVo() ;
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody ResponseVo getAccountByTelPhone() throws Exception {
        Detail detail = new Detail();
        detail.setIntroduce("111");
        detail.setPhotos("222");
        detailService.add(detail);
        return new ResponseVo();
    }

	
	

}
