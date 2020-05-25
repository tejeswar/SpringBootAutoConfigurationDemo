package com.hcl.propertysourceenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "classpath:propertysouce-env.properties" })
public class PropertySourceEnvConfiguration {

	@Autowired
    private Environment environment;
	
	@Bean
	public MyPropertySourceEnvConfig test1() {
		
		MyPropertySourceEnvConfig sourceEnvConfig = new 
		MyPropertySourceEnvConfig(environment.getProperty("app.name"),environment.getProperty("app.version"));
		
		return sourceEnvConfig;
		
	}
}
