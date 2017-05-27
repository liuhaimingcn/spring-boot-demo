package com.haiyue.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.haiyue.demo.models.yml.DruidConfig;
import com.haiyue.demo.models.yml.MysqlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ Created by liuhaiming on 2017/5/25.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.haiyue.demo.models.yml")
public class DruidConfiguration {

	@Autowired
	private MysqlConfig mysqlConfig;
	@Autowired
	private DruidConfig druidConfig;


	@Bean
	@Primary //在同样的DataSource中，首先使用被标注的DataSource
	public DataSource dataSource() {
		String url = mysqlConfig.getUrl();
		String username = mysqlConfig.getUsername();
		String password = mysqlConfig.getPassword();
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(druidConfig.getDriverClassName());
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setInitialSize(druidConfig.getInitialSize());
		druidDataSource.setMinIdle(druidConfig.getMinIdle());
		druidDataSource.setMaxActive(druidConfig.getMaxActive());
		druidDataSource.setMaxWait(druidConfig.getMaxWait());
		druidDataSource.setTimeBetweenEvictionRunsMillis(druidConfig.getTimeBetweenEvictionRunsMillis());
		druidDataSource.setMinEvictableIdleTimeMillis(druidConfig.getMinEvictableIdleTimeMillis());
		druidDataSource.setValidationQuery(druidConfig.getValidationQuery());
		druidDataSource.setTestWhileIdle(druidConfig.getTestWhileIdle());
		druidDataSource.setTestOnBorrow(druidConfig.getTestOnBorrow());
		druidDataSource.setTestOnReturn(druidConfig.getTestOnReturn());
		druidDataSource.setPoolPreparedStatements(druidConfig.getPoolPreparedStatements());
		Properties properties = new Properties();
		properties.setProperty("druid.stat.mergeSql", druidConfig.getConnectionProperties().get("mergeSql"));
		properties.setProperty("druid.stat.slowSqlMillis", druidConfig.getConnectionProperties().get("slowSqlMillis"));
		druidDataSource.setConnectProperties(properties);
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidConfig
				.getMaxPoolPreparedStatementPerConnectionSize());
		try {
			druidDataSource.setFilters(druidConfig.getFilters());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}
}


