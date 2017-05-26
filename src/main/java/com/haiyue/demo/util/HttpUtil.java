package com.haiyue.demo.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * HTTP 请求工具类,传入接收json格式
 *
 * @ Created by liuhaiming on 17/5/25.
 */
public class HttpUtil {
	// http请求设置为5秒超时
	private static final int timeout = 1000 * 5;
	private static RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout)
			.setConnectionRequestTimeout(timeout).setSocketTimeout(timeout).build();

	/**
	 * post 添加请求
	 *
	 * @param url 请求路径
	 * @param o   传入参数对象
	 * @return 获取到的结果字符串
	 * @throws Exception
	 */
	public static String httpPost(String url, Object o) throws Exception {
		String param = JacksonUtil.objectToString(o);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		StringEntity stringEntity = new StringEntity(param, "UTF-8");
		stringEntity.setContentType("application/json");
		httpPost.setEntity(stringEntity);
		CloseableHttpClient postClient = HttpClients.createDefault();
		try {
			CloseableHttpResponse httpPostRes = postClient.execute(httpPost);
			return getCloseableHttpResponse(httpPostRes, url, param);
		} catch (Exception e) {
			httpPost.abort();
			throw e;
		}
	}

	/**
	 * put 修改请求
	 *
	 * @param url 请求路径
	 * @param o   传入参数对象
	 * @return 获取到的结果字符串
	 * @throws Exception
	 */
	public static String httpPut(String url, Object o) throws Exception {
		String param = JacksonUtil.objectToString(o);
		HttpPut httpPut = new HttpPut(url);
		httpPut.setConfig(requestConfig);
		StringEntity stringEntity = new StringEntity(param, "UTF-8");
		stringEntity.setContentType("application/json");
		httpPut.setEntity(stringEntity);
		try {
			CloseableHttpResponse httpPutRes = HttpClients.createDefault().execute(httpPut);
			return getCloseableHttpResponse(httpPutRes, url, param);
		} catch (Exception e) {
			httpPut.abort();
			throw e;
		}
	}

	/**
	 * get 查询请求
	 *
	 * @param url      请求路径
	 * @param paramMap 传入的参数kv
	 * @return 获取到的结果字符串
	 * @throws Exception
	 */
	public static String httpGet(String url, Map<String, String> paramMap) throws Exception {
		HttpGet httpGet = new HttpGet(getURLEncoderUrl(url, paramMap));
		httpGet.setConfig(requestConfig);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			return getCloseableHttpResponse(httpResponse, url, null);
		} catch (Exception e) {
			httpGet.abort();
			throw e;
		}
	}

	/**
	 * delete 删除请求
	 *
	 * @param url      请求路径
	 * @param paramMap 传入的参数kv
	 * @return 获取到的结果字符串
	 * @throws Exception
	 */
	public static String httpDelete(String url, Map<String, String> paramMap) throws Exception {
		HttpDelete httpDelete = new HttpDelete(getURLEncoderUrl(url, paramMap));
		httpDelete.setConfig(requestConfig);
		try {
			CloseableHttpResponse httpResponse = HttpClients.createDefault().execute(httpDelete);
			return getCloseableHttpResponse(httpResponse, url, null);
		} catch (Exception e) {
			httpDelete.abort();
			throw e;
		}
	}

	/**
	 * 对请求结果进行统一处理
	 *
	 * @param httpResponse 响应结果
	 * @param url          请求路径
	 * @param param        请求参数字符串
	 * @return 响应结果字符串
	 * @throws Exception
	 */
	private static String getCloseableHttpResponse(CloseableHttpResponse httpResponse, String url, String param) throws Exception {
		HttpEntity httpEntity = httpResponse.getEntity();
		String result = EntityUtils.toString(httpEntity);
		if (httpResponse.getStatusLine().getStatusCode() != 200) {
			String errMsg = "http request error. ";
			errMsg += "\nstatusCode: " + httpResponse.getStatusLine().getStatusCode();
			errMsg += "\nurl: " + url;
			errMsg += "\nparam: " + param;
			errMsg += "\nerrorMsg: " + result;
			throw new Exception(errMsg);
		}
		return result;
	}

	/**
	 * 对get和delete请求的参数进行URLEncoder
	 *
	 * @param url      请求路径
	 * @param paramMap 请求参数
	 * @return URLEncoder 过后的请求地址
	 * @throws UnsupportedEncodingException
	 */
	private static String getURLEncoderUrl(String url, Map<String, String> paramMap) throws UnsupportedEncodingException {
		String result = "";
		if (paramMap != null && paramMap.keySet().size() > 0) {
			for (String key : paramMap.keySet()) {
				result += key + "=" + URLEncoder.encode(paramMap.get(key), "UTF-8") + "&";
			}
		}
		if (Utils.isNotEmptyString(result)) {
			result = "?" + result;
			result = result.substring(0, result.length() - 1);
		}
		return url + result;
	}
}
