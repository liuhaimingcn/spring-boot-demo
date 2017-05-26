package com.haiyue.demo.common;

import com.haiyue.demo.constant.ResponseStatus;
import com.haiyue.demo.exception.NoticeException;
import com.haiyue.demo.models.vo.ResponseVo;
import com.haiyue.demo.service.SendMessage;
import com.haiyue.demo.util.Utils;
import org.apache.catalina.connector.ClientAbortException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuhaiming
 */
public class BaseController {

	private static Logger log = LogManager.getLogger(BaseController.class.getName());

	@Autowired
	private SendMessage sendMessage;

	@ExceptionHandler()
	@ResponseBody
	protected ResponseVo handleException(Exception e) {
		String stackTraceStr = Utils.getStackTraceStr(e);
		log.error(stackTraceStr);
		if (e instanceof NoticeException
				|| e instanceof HttpMediaTypeNotAcceptableException
				|| e instanceof ClientAbortException) {
			return new ResponseVo(ResponseStatus.FORBIDDEN.VALUE, e.getMessage());
		} else {
			// 邮件通知
			sendMessage.sendEmail(e.getMessage(), stackTraceStr);
			return new ResponseVo(ResponseStatus.ERROR.VALUE, e.getLocalizedMessage());
		}
	}


}
