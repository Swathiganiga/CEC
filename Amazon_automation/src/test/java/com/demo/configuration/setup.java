package com.demo.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

;

public class setup {
	ConfigFileReader configFileReader;
	//WebDriver driver;
	 String option;
	public WebDriver setconfog(WebDriver driver) {
		configFileReader= new ConfigFileReader();
		//option = System.getProperty(configFileReader.getBrowserPath(), configFileReader.getDriverPath());
		//System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		//System.out.println(configFileReader.getBrowserPath());
		 //driver = new ChromeDriver();
		//driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(configFileReader.getApplicationUrl());
		return driver;
	}
}




//String webdriver = System.getProperty(configFileReader.getBrowserPath(), configFileReader.getDriverPath());
//System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
//driver = new ChromeDriver();
//driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
//driver.get(configFileReader.getApplicationUrl());
//return driver;
