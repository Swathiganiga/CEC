package com.demo.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.helper.assertion.VerificationHelper;
import com.demo.helper.logger.LoggerHelper;
import com.demo.helper.wait.waitHelper;




public class addToCart {
	private WebDriver driver;
	waitHelper waitHelper;
	private Logger log=LoggerHelper.getLogger(addToCart.class);

	
	@FindBy(xpath="//*[@id='hlb-view-cart-announce']")
	WebElement cartadd;
	
	@FindBy(xpath="//*[contains(text(),'Your shopping cart is empty')]")
	WebElement emptyshoppingcartmsg;
	

	@FindBy(xpath="//*[@id='nav-cart']")
	WebElement addcartbutton;
	
	@FindBy(xpath="//*[@id='attachDisplayAddBaseAlert']/div/h4")
	WebElement msgaddedtocart;

	public addToCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
      waitHelper = new waitHelper(driver);
      waitHelper.waitForElement(addcartbutton, 50);
      log.info("signin loaded");
		
	}
	
	public void clickcart()
	{
		this.cartadd.click();
	}
	public void mouseOverOnProductdelete(int num)
	{
           int k;
		 List<WebElement> myElements = driver.findElements(By.xpath("//input[@type='submit' and @value='Delete']"));
		 for( k=0;k<=myElements.size();k++) {
		if(k==num) {
			System.out.println("hello"+myElements.size());
			 System.out.println("k"+k);
			WebElement varee = myElements.get(num);
			varee.click();
			  
		 
		}
		else
		{
			 System.out.println("incresing k"+k);
			k++;
		}
		
	}
	}
	
	public void additemcart()
	{
		this.addcartbutton.click();
	}
	
	public boolean successmsg() {
		//TestBase.test.log(Status.INFO, "verifying msg sent");
		return new VerificationHelper(driver).isDisplayed(msgaddedtocart);
	}
	}