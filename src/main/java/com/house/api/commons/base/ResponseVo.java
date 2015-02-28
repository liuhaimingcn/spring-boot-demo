package com.house.api.commons.base;

import com.house.api.constant.ResponseStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wenfeng zhang @ 10/15/14
 */
public class ResponseVo implements Serializable{

	private static final long serialVersionUID = 6372741107786945383L;

	private static final ResponseStatus DEFAULT_STATUS = ResponseStatus.SUCCESS;

	public ResponseVo() {
		this.status = DEFAULT_STATUS.VALUE;
		this.message = DEFAULT_STATUS.MESSAGE;
	}

	public ResponseVo(Object data) {
		this.data = data;
		this.status = DEFAULT_STATUS.VALUE;
		this.message = DEFAULT_STATUS.MESSAGE;
	}

	public ResponseVo(ResponseStatus responseStatus) {
		this.status = responseStatus.VALUE;
		this.message = responseStatus.MESSAGE;
	}

	public ResponseVo(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

	public Integer status;
	public String message;
	private Long timstamp = new Date().getTime();
	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Long getTimstamp() {
		return timstamp;
	}

	public void setTimstamp(Long timstamp) {
		this.timstamp = timstamp;
	}
}
