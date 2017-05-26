package com.haiyue.demo.service.impl;

import com.haiyue.demo.mapper.UserMapper;
import com.haiyue.demo.models.User;
import com.haiyue.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author liuhaiming on 2017/5/25.
 */
@Service
public class UserMysqlServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(User user) {
		// 默认值
		user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setCreatedOn(new Date());
		userMapper.addUser(user);
	}

	@Override
	public void updateUserById(String id, User user) {
		user.setId(id);
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUserById(String id) {
		userMapper.deleteUserById(id);
	}

	@Override
	public User getUserById(String id) {
		return userMapper.getUserById(id);
	}
}
