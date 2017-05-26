package com.haiyue.demo.service.impl;

import com.haiyue.demo.models.User;
import com.haiyue.demo.models.yml.RedisConfig;
import com.haiyue.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author liuhaiming on 2017/5/25.
 */
@Service
public class UserRedisServiceImpl implements UserService {

	@Autowired
	private JedisPool jedisPool;
	@Autowired
	RedisConfig redisConfig;

	@Override
	public void addUser(User user) {
		Jedis jedis = getUserJedis();
		jedis.set(user.getUsername(), user.getPassword());
		jedis.close();
	}

	@Override
	public void updateUserById(String id, User user) {
		Jedis jedis = getUserJedis();
		jedis.set(id, user.getPassword());
		jedis.close();
	}

	@Override
	public void deleteUserById(String id) {
		Jedis jedis = getUserJedis();
		jedis.del(id);
		jedis.close();
	}

	@Override
	public User getUserById(String id) {
		Jedis jedis = getUserJedis();
		String password = jedis.get(id);
		jedis.close();
		User user = new User();
		user.setUsername(id);
		user.setPassword(password);
		return user;
	}

	private Jedis getUserJedis() {
		Jedis jedis = jedisPool.getResource();
		jedis.select(redisConfig.getUserDB());
		return jedis;
	}
}
