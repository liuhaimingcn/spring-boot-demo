package com.haiyue.demo.service.impl;

import com.haiyue.demo.service.SendMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * dev 环境下忽略邮件通知
 *
 * @ Created by liuhaiming on 2017/5/25.
 */
@Component
@Profile("dev")
public class SendMessageDev implements SendMessage {

	private static Logger log = LogManager.getLogger(SendMessageDev.class.getName());

	@Override
	public void sendEmail(String subject, String content) {
		log.debug("忽略发送错误邮件通知");
	}
}
