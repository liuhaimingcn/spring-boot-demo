package com.haiyue.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * 工具类
 *
 * @ Created by liuhaiming on 17/5/25.
 */
public class Utils {

	private static Logger log = LogManager.getLogger(Utils.class.getName());

	/**
	 * 判断字符串非空
	 *
	 * @return 是否为空(true为非空)
	 */
	public static boolean isNotEmptyString(String str) {
		return str != null && str.trim().length() > 0;
	}

	/**
	 * 根据不同的时间返回不同的颜色字体
	 */
	public static String getColorTime(long time) {
		String result;
		if (time <= 200) {
			result = getColorStr(time + "ms", "green");
		} else if (time <= 1000) {
			result = getColorStr(time + "ms", "blue");
		} else if (time <= 5000) {
			result = getColorStr(time + "ms", "yellow");
		} else {
			result = getColorStr(time + "ms", "red");
		}
		return result;
	}

	/**
	 * 获取不同颜色的文字
	 */
	private static String getColorStr(String str, String color) {
		String tmp;
		switch (color) {
			case "red":
				tmp = "\033[31m";
				break;
			case "green":
				tmp = "\033[32m";
				break;
			case "yellow":
				tmp = "\033[33m";
				break;
			case "blue":
				tmp = "\033[34m";
				break;
			default:
				tmp = "";
				break;
		}
		return tmp + str + "\033[0m";
	}

	/**
	 * @param subject 邮件标题
	 * @param content 邮件内容
	 */
	public static void sendEmail(String subject, String content) {
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.126.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("java_demo666@126.com", "java-demo(" + getHostAddress() + ")报错通知"));
			msg.setSubject(isNotEmptyString(subject) ? subject : "info");
			msg.setContent(content, "text/html;charset=UTF-8");
			Address[] addressArr = new Address[5];
			addressArr[0] = new InternetAddress("liuhaiming.cn@gmail.com");
			msg.setRecipients(Message.RecipientType.TO, addressArr);

			Transport transport = session.getTransport();
			transport.connect("smtp.126.com", "java_demo666@126.com", "666java_demo666");
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			log.info("邮件发送成功, subject:" + subject);
		} catch (Exception e) {
			log.error(getStackTraceStr(e));
		}
	}

	/**
	 * @return 本机的内网ip
	 */
	private static String getHostAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return "getHostAddress Error!";
		}
	}

	/**
	 * 将错误中转换成字符串
	 */
	public static String getStackTraceStr(Exception e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		printWriter.close();    //surprise no IO exception here
		try {
			stringWriter.close();
			return stringWriter.toString();
		} catch (IOException ie) {
			log.error(ie.getMessage());
			ie.printStackTrace();
			return "";
		}
	}

	/**
	 * 根据文件路径获取对应的InputStream
	 */
	public static InputStream getFileInputStream(String path) {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("classpath:" + path);
		try {
			return resource.getInputStream();
		} catch (IOException e) {
			return new ByteArrayInputStream("".getBytes());
		}
	}

	public static void main(String[] args) {
		Utils.sendEmail("测试邮件", "啦啦啦啦,我是测试!!!");
	}
}
