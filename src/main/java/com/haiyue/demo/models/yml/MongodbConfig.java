package com.haiyue.demo.models.yml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ Created by liuhaiming on 2016/10/18.
 */
@Component
@ConfigurationProperties(prefix = "mongodbConfig")
public class MongodbConfig implements Serializable {

	private static final long serialVersionUID = 3860799287246155143L;

	private String host1;
	private Integer port1;
	private String host2;
	private Integer port2;
	private String username;
	private String password;
	private String database;

	public String getHost1() {
		return host1;
	}

	public void setHost1(String host1) {
		this.host1 = host1;
	}

	public Integer getPort1() {
		return port1;
	}

	public void setPort1(Integer port1) {
		this.port1 = port1;
	}

	public String getHost2() {
		return host2;
	}

	public void setHost2(String host2) {
		this.host2 = host2;
	}

	public Integer getPort2() {
		return port2;
	}

	public void setPort2(Integer port2) {
		this.port2 = port2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}
