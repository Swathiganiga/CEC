package com.demo.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.demo.helper.browserConfiguration.BrowserType;
import com.demo.helper.browserConfiguration.ChromeBrowser;
import com.demo.helper.browserConfiguration.config.objectReader;
import com.demo.helper.logger.LoggerHelper;
import com.demo.helper.wait.waitHelper;

public class TestBase {
	public WebDriver driver;
	private Logger log=LoggerHelper.getLogger(TestBase.class);




	
	public WebDriver getBrowserObject(BrowserType btype)
	{
		try {
			switch(btype) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getchromeDriver(option);
			
				
			default:
				break;
			
			}
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
		}
		System.out.println("driver is"+driver);
		return null;
	
		
	
	}
	public void setUpdriver(BrowserType btype) throws Exception
	{
		
		driver=getBrowserObject(btype);
		//log.info("initilized to web driver"+driver.hashCode());
		System.out.println("driver is"+driver);
		waitHelper wait = new waitHelper(driver);
		wait.setImplicitWait(objectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(objectReader.reader.getExplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	
	
	public void getAppUrl(String url)
	{
		driver.get(url);
	}
}

