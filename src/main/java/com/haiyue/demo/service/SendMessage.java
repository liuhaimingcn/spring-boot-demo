package com.haiyue.demo.service;

/**
 * @ Created by liuhaiming on 2017/5/25.
 */
public interface SendMessage {

    // 发送邮件通知
    void sendEmail(String subject, String content);
}
