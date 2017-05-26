package com.haiyue.demo.models.yml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ Created by liuhaiming on 2016/10/18.
 */
@Component
@ConfigurationProperties(prefix = "redisConfig")
public class RedisConfig implements Serializable {

	private static final long serialVersionUID = 1097752157567754456L;
	private String host;
	private Integer port;
	private String password;
	private Integer timeOut;
	private Integer maxTotal;
	private Integer maxIdle;
	private Long maxWaitMillis;
	private Boolean testOnBorrow;
	private Integer userDB;

	public Integer getUserDB() {
		return userDB;
	}

	public void setUserDB(Integer userDB) {
		this.userDB = userDB;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(Long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
}
