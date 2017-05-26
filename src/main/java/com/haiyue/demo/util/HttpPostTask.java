package com.haiyue.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 多线程异步post请求
 *
 * @ Created by liuhaiming on 17/5/25.
 */
public class HttpPostTask implements Callable<String> {
	private static Logger log = LogManager.getLogger(HttpPostTask.class.getName());
	private String url;
	private Object params;

	public HttpPostTask(String url, Object params) {
		this.url = url;
		this.params = params;
	}

	@Override
	public String call() throws Exception {
		Date date = new Date();
		String s = HttpUtil.httpPost(url, params);
		log.debug("http请求用时:" + (System.currentTimeMillis() - date.getTime()) + ", url:" + url);
		return s;
	}
}
