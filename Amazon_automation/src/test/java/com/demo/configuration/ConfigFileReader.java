package com.demo.configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.demo.helper.resourceHelper.resourceHelper;


public class ConfigFileReader {
	private Properties properties;
	//private final String propertyFilePath= "E://PAGE OBJECT MODEL//automation2//src//test//resources//configfile//config.properties";
	private final String  propertyFilePath=resourceHelper.getResourcePath("/src/test/resources/configfile/config.properties");
       
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			System.out.println("hi"+propertyFilePath);
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverpath");
		if(driverPath!= null) return driverPath;
		
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitwait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("applicationUrl");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getBrowser() {
		String browsers = properties.getProperty("browser");
		if(browsers != null) return browsers;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

}