package com.haiyue.demo.service.impl;

import com.haiyue.demo.service.SendMessage;
import com.haiyue.demo.util.Utils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * test 和 prod 环境下错误邮件通知
 *
 * @ Created by liuhaiming on 2017/5/25.
 */
@Component
@Profile({"test", "prod"})
public class SendMessageTestAndProd implements SendMessage {
	@Override
	public void sendEmail(String subject, String content) {
		Utils.sendEmail(subject, content);
	}
}
