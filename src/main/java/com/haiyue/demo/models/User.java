package com.haiyue.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jongo.marshall.jackson.oid.MongoId;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuhaiming on 2017/5/25.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // null的字段不返回
public class User implements Serializable {

	private static final long serialVersionUID = 3383602165827024134L;
	@MongoId
	private String id;
	private String username;
	private String password;
	private Date createdOn;
	private Date updatedOn;
	private Integer delStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
