package com.demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.helper.browserConfiguration.config.objectReader;
import com.demo.helper.logger.LoggerHelper;
import com.demo.helper.wait.waitHelper;

public class signInPage {
	private WebDriver driver;
	waitHelper waitHelper;
	private Logger log=LoggerHelper.getLogger(signInPage.class);

	
	@FindBy(xpath="//*[@id='nav-link-accountList']/span[1]")
	WebElement signinlink;
	
	@FindBy(xpath="//*[@id='nav-flyout-ya-signin']/a/span")
	WebElement signinbutton;
	
	@FindBy(xpath="//*[@id='ap_email']")
	WebElement email;
	
	@FindBy(xpath="//*[@id='continue']")
	WebElement emailnext;
	
	@FindBy(xpath="//*[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='signInSubmit']")
	WebElement signInSubmit;
	
	



	public signInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
      waitHelper = new waitHelper(driver);
     
      waitHelper.waitForElement(signinlink, 50);
      log.info("signin loaded");
   // System.out.println("swathi-----"+objectReader.reader.getExplicitWait());
		
	}
	
	public void enteremail(String email)
	{
		this.email.sendKeys(email);
	}
	
	public void enterContinue()
	{
		this.emailnext.click();
	}
	public void enterpassword(String pass)
	{
		this.password.sendKeys(pass);
	}
	
	public void enterSubmit()
	{
		this.signInSubmit.click();
	}
	
	
	public void mouseOverOnProduct()
	{
		
		Actions action=new Actions(driver);
	
		action.moveToElement(signinlink).build().perform();
	}
	public void clicksignin()
	{
		WebElement sendIssue =(WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav-link-accountList']/span[1]")));
		sendIssue.click();
		
	}
}


