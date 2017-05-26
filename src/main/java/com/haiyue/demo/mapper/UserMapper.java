package com.haiyue.demo.mapper;


import com.haiyue.demo.models.User;

/**
 * @author liuhaiming
 */
public interface UserMapper {

	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(String id);

	User getUserById(String id);
}