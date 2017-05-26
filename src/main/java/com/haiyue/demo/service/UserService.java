package com.haiyue.demo.service;

import com.haiyue.demo.models.User;

/**
 * @author liuhaiming on 2017/5/25.
 */
public interface UserService {

	/**
	 * 添加用户
	 *
	 * @param user 用户信息
	 */
	void addUser(User user);

	/**
	 * 根据用户主键修改用户
	 *
	 * @param id   用户主键
	 * @param user 用户信息
	 */
	void updateUserById(String id, User user);

	/**
	 * 更加用户主键删除用户
	 *
	 * @param id 用户主键
	 */
	void deleteUserById(String id);

	/**
	 * 根据主键获取用户信息
	 *
	 * @param id 用户主键
	 * @return 用户详情
	 */
	User getUserById(String id);
}
