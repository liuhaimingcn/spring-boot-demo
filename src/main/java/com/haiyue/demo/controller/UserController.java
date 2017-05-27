package com.haiyue.demo.controller;

import com.haiyue.demo.common.BaseController;
import com.haiyue.demo.mapper.UserMapper;
import com.haiyue.demo.models.User;
import com.haiyue.demo.models.vo.ResponseVo;
import com.haiyue.demo.service.impl.UserMongoServiceImpl;
import com.haiyue.demo.service.impl.UserMysqlServiceImpl;
import com.haiyue.demo.service.impl.UserRedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * @ Created by liuhaiming on 2017/5/25.
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

	@Autowired
	private UserMongoServiceImpl mongoService;
	@Autowired
	private UserMysqlServiceImpl mysqlService;
	@Autowired
	private UserRedisServiceImpl redisService;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseVo getUserById(@PathVariable String id) throws Exception {
//		User user = mongoService.getUserById(id);
//		User user = redisService.getUserById(id);
		User user = mysqlService.getUserById(id);
		return new ResponseVo(user);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseVo addUser(@RequestBody User user) throws Exception {
//		mongoService.addUser(user);
//		redisService.addUser(user);
		mysqlService.addUser(user);
		return new ResponseVo();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseVo updateUserById(@PathVariable String id, @RequestBody User user) throws Exception {
//		mongoService.updateUserById(id, user);
//		redisService.updateUserById(id, user);
		mysqlService.updateUserById(id, user);
		return new ResponseVo();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseVo deleteUserById(@PathVariable String id) throws Exception {
//		mongoService.deleteUserById(id);
//		redisService.deleteUserById(id);
		mysqlService.deleteUserById(id);
		return new ResponseVo();
	}
}
