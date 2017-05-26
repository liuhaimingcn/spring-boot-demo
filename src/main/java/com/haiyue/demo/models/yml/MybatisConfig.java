package com.haiyue.demo.models.yml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ Created by liuhaiming on 2016/10/18.
 */
@Component
@ConfigurationProperties(prefix = "mybatisConfig")
public class MybatisConfig implements Serializable {

	private static final long serialVersionUID = 3729982970724303556L;
	private String typeAliasesPackage;
	private String mapperLocations;

	public String getTypeAliasesPackage() {
		return typeAliasesPackage;
	}

	public void setTypeAliasesPackage(String typeAliasesPackage) {
		this.typeAliasesPackage = typeAliasesPackage;
	}

	public String getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
}
