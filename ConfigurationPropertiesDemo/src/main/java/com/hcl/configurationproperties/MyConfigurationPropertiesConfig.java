package com.hcl.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:configurationproperties-dev.properties" })
@ConfigurationProperties(prefix = "tej")
public class MyConfigurationPropertiesConfig {


	
	private String hostname;
	private String port;
	private String from;
	
	public MyConfigurationPropertiesConfig() {
		
	}

	public MyConfigurationPropertiesConfig(String hostname, String port, String from) {
		super();
		this.hostname = hostname;
		this.port = port;
		this.from = from;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "ConfigurationPropertiesConfiguration [hostname=" + hostname + ", port=" + port + ", from=" + from + "]";
	}
	
	


}
