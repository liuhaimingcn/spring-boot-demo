package com.haiyue.demo.config;

import com.haiyue.demo.common.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ Created by liuhaiming on 2016/10/19.
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/error");
		super.addInterceptors(registry);
	}
}
