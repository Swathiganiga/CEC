package com.demo.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.demo.helper.resourceHelper.resourceHelper;



public class ChromeBrowser {
	
public ChromeOptions getChromeOptions() {
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--test-type");
	option.addArguments("--disable-popup-blocking--");
	DesiredCapabilities chrome=DesiredCapabilities.chrome();
	chrome.setJavascriptEnabled(true);
	option.setCapability(ChromeOptions.CAPABILITY, chrome);
	if(System.getProperty("os.name").contains("Linux")) {
		option.addArguments("--headless","window-size=1024,768", "--no-sandbox");
	}
	return option;
	
}
public WebDriver getchromeDriver(ChromeOptions cap)
{
	if(System.getProperty("os.name").contains("Mac")) {
		System.setProperty("webdriver.chrome.driver", resourceHelper.getResourcePath("E:/downloads/chromedriver_win32 (1)/chromedriver.exe"));
		return new ChromeDriver(cap);
	}
	else if(System.getProperty("os.name").contains("Window")) {
		System.setProperty("webdriver.chrome.driver", resourceHelper.getResourcePath("/src/test/resources/drivers/chromedriver_win32 (1)/chromedriver.exe"));
		System.out.println("hi");
		return new ChromeDriver(cap);
	}
	return null;
}
}
