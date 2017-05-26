package com.haiyue.demo.controller;

import com.haiyue.demo.common.BaseController;
import com.haiyue.demo.models.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhaiming
 */
@RestController
@RequestMapping("/")
public class HealthController extends BaseController {

	@RequestMapping()
	public ResponseVo getHealth() throws Exception {
		return new ResponseVo();
	}
}
