package com.haiyue.demo.config;

import com.haiyue.demo.models.yml.MybatisConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @ Created by liuhaiming on 2017/5/25.
 */
@Configuration
@MapperScan(basePackages = "com.haiyue.demo.mapper")
@AutoConfigureAfter(DruidConfiguration.class)
@ComponentScan({"com.haiyue.demo.config", "com.haiyue.demo.models.yml"})
public class MybatisConfiguration implements TransactionManagementConfigurer {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private MybatisConfig mybatisConfig;

	@Bean
	public SqlSessionFactory sqlSessionFactory() {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage(mybatisConfig.getTypeAliasesPackage());

		//添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources(mybatisConfig.getMapperLocations()));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}


