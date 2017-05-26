package com.haiyue.demo.config;

import com.haiyue.demo.models.yml.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ Created by liuhaiming on 2016/10/18.
 */
@Configuration
@ComponentScan({"com.haiyue.demo.models.yml"})
public class JedisConfiguration {

	@Autowired
	RedisConfig redisConfig;

	@Bean
	public JedisPool jedisPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(redisConfig.getMaxIdle());
		config.setMaxTotal(redisConfig.getMaxTotal());
		config.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
		config.setTestOnBorrow(redisConfig.getTestOnBorrow());

		return new JedisPool(config, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeOut()
				, redisConfig.getPassword());
	}
}


