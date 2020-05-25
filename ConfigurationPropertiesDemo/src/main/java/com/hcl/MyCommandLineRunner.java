package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hcl.configurationproperties.MyConfigurationPropertiesConfig;
import com.hcl.propertysourceenv.MyPropertySourceEnvConfig;
import com.hcl.vlaue.ValueConfig;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private ValueConfig valueConfig;

	//@Autowired(required = false)
	@Autowired
	private MyPropertySourceEnvConfig propSourceEnvConfig;
	
	@Autowired
	private MyConfigurationPropertiesConfig  configurationPropertiesConfig;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(valueConfig);
		
		
		System.out.println(propSourceEnvConfig);
		
		System.out.println(configurationPropertiesConfig);
	}

}
