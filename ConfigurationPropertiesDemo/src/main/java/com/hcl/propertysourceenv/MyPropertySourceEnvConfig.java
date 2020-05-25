package com.hcl.propertysourceenv;

public class MyPropertySourceEnvConfig {

	private String appName;
	private String appVersion;
	
	public MyPropertySourceEnvConfig() {
		
	}

	public MyPropertySourceEnvConfig(String appName, String appVersion) {
		super();
		this.appName = appName;
		this.appVersion = appVersion;
	}
	
	

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	@Override
	public String toString() {
		return "MyPropertySourceEnvConfig [appName=" + appName + ", appVersion=" + appVersion + "]";
	}
	
	
}
