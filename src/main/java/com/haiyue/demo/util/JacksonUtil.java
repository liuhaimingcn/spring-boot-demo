package com.haiyue.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Jackson 处理json的工具类
 *
 * @author liuhaiming on 2017/5/25.
 */
public class JacksonUtil {
	// 获取一个统一的ObjectMapper
	public static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 将一个对象写成json字符串
	 *
	 * @param entity 对象
	 * @return json字符串
	 * @throws JsonProcessingException
	 */
	public static String objectToString(Object entity) throws JsonProcessingException {
		return objectMapper.disableDefaultTyping().writeValueAsString(entity);
	}

	/**
	 * 将一个json字符串转成对象
	 *
	 * @param jsonStr json字符串
	 * @param T       对象类型
	 * @return 对象
	 * @throws IOException
	 */
	public static <T> T stringToObject(String jsonStr, Class<T> T) throws IOException {
		return objectMapper.readValue(jsonStr, T);
	}

	public static void main(String[] args) throws IOException {
		Map<String, String> res = new HashMap<>();
		res.put("a", "a");
		res.put("b", "a");

		String json = JacksonUtil.objectToString(res);
		Map map = JacksonUtil.stringToObject(json, Map.class);
		System.out.println(map.get("a"));
	}

}
