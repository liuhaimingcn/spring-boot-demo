package com.haiyue.demo.exception;

import com.haiyue.demo.common.BaseException;

/**
 * 业务逻辑错误
 */
public class BusinessException extends BaseException {

	private static final long serialVersionUID = 8156693665274189605L;

	public BusinessException(String msg) {
		super(msg);
	}


}
