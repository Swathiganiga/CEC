package com.demo.helper.webDriver;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Driver {
public static WebDriver webdriver;
	
	public synchronized static WebDriver getCurrentDriver() {
		
		
		return webdriver;
	}

	public static String takeScreenshot(String filename) throws IOException {
		
		try {
			File file = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.FILE);
			String filePath = ("./screenshot/" + filename + ".jpg");
			FileUtils.copyFile(file, new File(filePath));
			return filePath;
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			return null;
		}
	}

	public static void embedScreenshot() {
		
	}

	public static void writeToReport(String string) {
		//TestRunner.scenario.write(string);
	}
	
}