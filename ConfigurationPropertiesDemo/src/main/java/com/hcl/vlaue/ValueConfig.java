package com.hcl.vlaue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:valueconfiguration.properties" })
public class ValueConfig {

	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private int age;
	//whether the key is there or not in the properties file,the value is always going to be true
	@Value("true")  
	private boolean defaultHindu;
	//assigning a default value that will get assigned if the key is missing from spring environment properties only.
	@Value("${caste}:Hindu")
	private String caste;
	
	@Value("Test")
	public void printValues(String s, String v){
		System.out.println(s + " : "+v);
		
	}
	@Value("Like")
	public void printValues1(String s, @Value("Data") String v){
		System.out.println(s + " : "+v);	
	}
	
	public ValueConfig() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	
	@Override
	public String toString() {
		return "ValueConfig [name=" + name + ", age=" + age +", caste="+ caste +", defaultHindu=" + defaultHindu + "]";
	}
	
	
}
