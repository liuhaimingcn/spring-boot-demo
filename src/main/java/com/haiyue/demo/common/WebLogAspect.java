package com.haiyue.demo.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ Created by liuhaiming on 16/7/27.
 */
@Aspect
@Component
public class WebLogAspect {

	private static Logger log = LogManager.getLogger(WebLogAspect.class.getName());

	// 忽略健康检查的请求日志
	@Pointcut("execution(public * com.haiyue.demo.controller.*.*(..)) && !execution(public * com.haiyue.demo.controller.HealthController.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		log.info("params: " + Arrays.toString(joinPoint.getArgs()));

	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("response: " + ret);
	}

}
