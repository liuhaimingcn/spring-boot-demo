package com.haiyue.demo.common;

import com.haiyue.demo.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Created by liuhaiming on 16/7/27.
 */
public class RequestInterceptor implements HandlerInterceptor {

	private static Logger log = LogManager.getLogger(RequestInterceptor.class.getName());

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		long startTime = System.currentTimeMillis();
		httpServletRequest.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
		String requestURI = httpServletRequest.getRequestURI();
		String method = httpServletRequest.getMethod();
		String remoteAddress = httpServletRequest.getRemoteAddr();
		long startTime = (Long) httpServletRequest.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		log.info(method + " " + requestURI + " " + Utils.getColorTime(executeTime) + " ip:" + remoteAddress);
	}
}
