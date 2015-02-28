package com.house.api.commons.base;

import com.house.api.constant.ResponseStatus;
import com.house.api.exception.NoticeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wenfeng zhang
 */
public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected ResponseVo handleException(Exception e) {
		logger.error(e.getMessage(), e);
		if (e instanceof HttpMessageNotReadableException ||
				e instanceof NumberFormatException ||
				e instanceof InvalidPropertyException){
			return new ResponseVo(ResponseStatus.DATA_PARSE_ERROR.VALUE, e.getLocalizedMessage());
		} else if (e instanceof NoticeException) {
            return new ResponseVo(ResponseStatus.FORBIDDEN.VALUE, e.getMessage());
        }
		return new ResponseVo(ResponseStatus.ERROR.VALUE,e.getLocalizedMessage());
	}

}
