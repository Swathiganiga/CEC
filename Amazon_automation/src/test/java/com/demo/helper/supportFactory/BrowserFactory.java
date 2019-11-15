package com.demo.helper.supportFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.demo.helper.enums.Browser;
import com.demo.runner.mainRunner;

/*public class BrowserFactory {
//static Browser browser = Browser.valueOf(mainRunner.config.get("browser"));
	
	//static String desiredBrowserVersion = mainRunner.config.get("browserVersion");

	public static DesiredCapabilities selectBrowser(DesiredCapabilities caps) {
		
		//switch (browser) {
		
		//case Chrome:
			caps.setCapability("browserName", "chrome");
			break;
		case Firefox:
			 caps.setCapability("browserName", "firefox");
			 break;
	
		case IE:
			caps.setCapability("browserName", "internet explorer");
			caps.setCapability("browserstack.ie.enablePopups", "true");
			break;
	
		default:
			throw new WebDriverException("No browser specified");
		}
		caps.setCapability("version", desiredBrowserVersion);
		return caps;
	}
	
	public static WebDriver selectLocalBrowser() {
		switch (browser) {
		case Chrome:
			return new ChromeDriver();
		case Firefox:
			return new FirefoxDriver();
		case IE:
			return new InternetExplorerDriver();
		
		default:
			throw new WebDriverException("No browser specified");
		}
	}
}*/