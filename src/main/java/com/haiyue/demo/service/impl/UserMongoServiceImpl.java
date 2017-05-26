package com.haiyue.demo.service.impl;

import com.haiyue.demo.models.User;
import com.haiyue.demo.service.UserService;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhaiming on 2017/5/25.
 */
@Service
public class UserMongoServiceImpl implements UserService {

	@Autowired
	private Jongo jongo;

	// 获取到要操作的collection
	private MongoCollection getMongoCollection() {
		return jongo.getCollection("user");
	}

	@Override
	public void addUser(User user) {
		getMongoCollection().insert(user);
	}

	@Override
	public void updateUserById(String id, User user) {
		getMongoCollection().update(new ObjectId(id)).with(user);
	}

	@Override
	public void deleteUserById(String id) {
		getMongoCollection().remove(new ObjectId(id));
	}

	@Override
	public User getUserById(String id) {
//		return getMongoCollection().findOne("{_id:#}", new ObjectId(id)).as(User.class);
		return getMongoCollection().findOne(new ObjectId(id)).as(User.class);
	}
}
