package com.demo.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.helper.browserConfiguration.config.objectReader;
import com.demo.helper.logger.LoggerHelper;
import com.demo.helper.wait.waitHelper;

public class Mainpage {
	private WebDriver driver;
	waitHelper waitHelper;
	private Logger log=LoggerHelper.getLogger(Mainpage.class);

	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement serachbox;
	
	@FindBy(xpath="//*[@id='nav-search']/form/div[2]/div/input")
	WebElement imgsearch;

	@FindBy(xpath="//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[4]/div/div/div/div[2]/div[1]/div/div/span/a/div/img")
	WebElement trailss;
	


	public Mainpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
      waitHelper = new waitHelper(driver);
      waitHelper.waitForElement(serachbox, 50);
      log.info("signin loaded");
		
		
	}
	public void getTitles(String arg1 )
	{
		
		WebElement VAR = driver.findElement(By.xpath(arg1));
		String titleValue=VAR.getAttribute("alt");
		System.out.println("titlevalue is ----"+titleValue);
		
	}

public productDescription mouseOverOnProduct(int number)
{
	String fPart = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[";
	String sPart = "]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img";
	Actions action=new Actions(driver);
	String vari = fPart+number+sPart;
	action.moveToElement(driver.findElement(By.xpath(fPart+number+sPart))).build().perform();
	WebElement var = driver.findElement(By.xpath(fPart+number+sPart));
	getTitles(vari);
			var.click();
			return new productDescription(driver);
}

	
	public void serachbox(String item)
	{
		this.serachbox.sendKeys(item);
	}
	
	public void serachimgclick()
	{
		this.imgsearch.click();
	}

	public void trials() {
		this.trailss.click();
		
	}
	
	
	



}


