package com.demo.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.demo.helper.logger.LoggerHelper;



public class VerificationHelper {
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(VerificationHelper.class);
	public VerificationHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean isDisplayed(WebElement element)
	
	{
		try
		{
			element.isDisplayed();
			log.info("element is displayed..."+element.getText());
			return true;
		}
		catch(Exception e)
		{
			log.error("element is not diplayed...",e.getCause());
			return false;
		}
	}
public boolean isNotDisplayed(WebElement element)
	
	{
		try
		{
			element.isDisplayed();
			log.info("element is present..."+element.getText());
			return false;
		}
		catch(Exception e)
		{
			log.error("element is not present...");
			return true;
		}
	}
public String readValueFromElement(WebElement element) {
	
	if(null==element) {
		log.info("wEBeLEMENT IS NULL");  
		return null;
}
boolean status = isDisplayed(element);
if(status)
{
	log.info("eleemnt text is.."+element.getText());
	return element.getText();
}
else
{
	return null;
}
}
public String getText(WebElement element) {
	
	if(null==element) {
		log.info("wEBeLEMENT IS NULL");  
		return null;
}
boolean status = isDisplayed(element);
if(status)
{
	log.info("eleemnt text is.."+element.getText());
	return element.getText();
}
else
{
	return null;
}
}
}

