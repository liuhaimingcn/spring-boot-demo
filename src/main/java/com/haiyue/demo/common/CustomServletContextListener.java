package com.haiyue.demo.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author liuhaiming 2016/10/28.
 */
@WebListener
public class CustomServletContextListener implements ServletContextListener {
	private static Logger log = LogManager.getLogger(CustomServletContextListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		try {
			log.debug("项目启动后初始化一些信息……………………");
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
