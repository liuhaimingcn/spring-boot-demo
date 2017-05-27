package com.haiyue.demo.controller;

import com.haiyue.demo.common.BaseController;
import com.haiyue.demo.models.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Created by liuhaiming on 2017/5/25.
 */
@RestController
@RequestMapping("/")
public class HealthController extends BaseController {

	@RequestMapping()
	public ResponseVo getHealth() throws Exception {
		return new ResponseVo();
	}
}
