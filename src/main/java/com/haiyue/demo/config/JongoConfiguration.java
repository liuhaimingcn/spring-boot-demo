package com.haiyue.demo.config;

import com.haiyue.demo.models.yml.MongodbConfig;
import com.mongodb.*;
import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Created by liuhaiming on 2016/10/18.
 */
@Configuration
@ComponentScan({"com.haiyue.demo.models.yml"})
public class JongoConfiguration {

	@Autowired
	MongodbConfig mongodbConfig;

	@Bean
	@Primary //在同样的DataSource中，首先使用被标注的DataSource
	public Jongo jongo() {
		ServerAddress serverAddress1 = new ServerAddress(mongodbConfig.getHost1(), mongodbConfig.getPort1());
		ServerAddress serverAddress2 = new ServerAddress(mongodbConfig.getHost2(), mongodbConfig.getPort2());
		List<ServerAddress> serverAddressList = new ArrayList<>();
		serverAddressList.add(serverAddress1);
		serverAddressList.add(serverAddress2);
		MongoCredential credential = MongoCredential.createScramSha1Credential(mongodbConfig.getUsername()
				, mongodbConfig.getDatabase(), mongodbConfig.getPassword().toCharArray());
		List<MongoCredential> credentials = new ArrayList<>();
		credentials.add(credential);
		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(50).maxWaitTime(5000).build();
		DB db = new MongoClient(serverAddressList, credentials, options).getDB(mongodbConfig.getDatabase());
		return new Jongo(db);
	}
}


