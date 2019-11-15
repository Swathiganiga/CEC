package com.demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.helper.logger.LoggerHelper;
import com.demo.helper.wait.waitHelper;

public class productDescription {
	private WebDriver driver;
	waitHelper waitHelper;
	private Logger log=LoggerHelper.getLogger(productDescription.class);

	
	@FindBy(xpath="//*[@id='add-to-cart-button']")
	WebElement addtocart;
	
	
	
	



	public productDescription(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
      waitHelper = new waitHelper(driver);
      waitHelper.waitForElement(addtocart, 50);
      log.info("signin loaded");
		
	}
	
	
	public void addtocarts()
	{
		this.addtocart.click();
	}
	}