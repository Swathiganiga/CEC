package com.demo.helper.new1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.configuration.ConfigFileReader;

public class DriverFactorya {
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public WebDriver setup(String browser) {
		System.out.println("browser is  "+browser);
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("Firefox")){
		//create firefox instance
			System.setProperty("webdriver.firefox.marionette", ".E://downloads//firefox//geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("driver is a "+driver);
		}
		//Check if parameter passed as 'chrome'
		else if( browser.equalsIgnoreCase("Chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","E://downloads//chromedriver_win32 (1)//chromedriver.exe");
			System.out.println("genisys");
			driver = new ChromeDriver();
			System.out.println("driver is a "+driver);
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver","E://downloads//MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
		
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		System.out.println("driver is"+driver);
		setconfog(driver);
		return driver;
	}
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
