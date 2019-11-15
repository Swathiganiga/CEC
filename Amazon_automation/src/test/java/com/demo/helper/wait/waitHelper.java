package com.demo.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.helper.logger.LoggerHelper;




public class waitHelper {
	private WebDriver driver;
private Logger log=LoggerHelper.getLogger(waitHelper.class);
public waitHelper(WebDriver driver)
{
	this.driver=driver;
	
}

/**
 * this is implicit wait method
 * @param timeout
 * @param unit
 */
public void setImplicitWait(long timeout, TimeUnit unit) {
	log.info("implicit wait has been set to "+timeout);
	driver.manage().timeouts().implicitlyWait(timeout, unit);
	
}
/**
 * This will help us to get webdriverwait object
 * @param TimeOutInSecond
 * @param PollingEveryInMilliSeccond
 * @return
 */
private WebDriverWait getWait(int TimeOutInSecond, int PollingEveryInMilliSeccond)
{
	WebDriverWait wait= new WebDriverWait(driver,TimeOutInSecond);
	wait.pollingEvery(Duration.ofMillis(PollingEveryInMilliSeccond));

	wait.ignoring(NoSuchElementException.class);
	wait.ignoring(ElementNotVisibleException.class);
	wait.ignoring(StaleElementReferenceException.class);
	wait.ignoring(NoSuchFrameException.class);
	
	return wait;
}

/**
 * Element is visible
 * @param element
 * @param TimeOutInSecond
 * @param PollingEveryInMilliSeccond
 */
public void WaitForElementVisibleWithPolling(WebElement element,int TimeOutInSecond,int PollingEveryInMilliSeccond)
{
	log.info("waitig for" +element.toString()+"for " +TimeOutInSecond+ "seconds");
	WebDriverWait wait=getWait(TimeOutInSecond, PollingEveryInMilliSeccond);
	wait.until(ExpectedConditions.visibilityOf(element));

	log.info("element is visible");
}
/**
 * method will make sure element is WaitForElementClickable
 * @param element
 * @param TimeOutInSecond
 * @param PollingEveryInMilliSeccond
 */
public void WaitForElementClickable(WebElement element,int TimeOutInSecond,int PollingEveryInMilliSeccond)
{
	log.info("waitig for" +element.toString()+"for " +TimeOutInSecond+ "seconds");
	WebDriverWait wait=new WebDriverWait(driver,TimeOutInSecond);
	wait.until(ExpectedConditions.elementToBeClickable(element));

	log.info("element is clickable");
}

/**
 * invisibility of element
 * @param element
 * @param TimeOutInSecond
 * @return
 */
public boolean waitForElementNotPresent(WebElement element,long TimeOutInSecond) {
	log.info("waitig for" +element.toString()+"for " +TimeOutInSecond+ "seconds");
	WebDriverWait wait=new WebDriverWait(driver,TimeOutInSecond);
	boolean status=wait.until(ExpectedConditions.invisibilityOf(element));
	log.info("element is invisible");
	return status;
}
/**
 * method will wait for frame and switch to it
 * @param element
 * @param TimeOutInSecond
 */
public void waitFoframeToBeAvailableAndSwitchToIt(WebElement element,long TimeOutInSecond) {
	log.info("waitig for" +element.toString()+"for " +TimeOutInSecond+ "seconds");
	WebDriverWait wait=new WebDriverWait(driver,TimeOutInSecond);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	log.info("frame is available and switched");
	
}

/**
 * method will give is fluentwait object
 * @param TimeOutInSecond
 * @param PollingEveryInMilliSeccond
 * @return
 */
private Wait<WebDriver> fluentWait(int TimeOutInSecond, int PollingEveryInMilliSeccond)
{
Wait<WebDriver> fwait =new FluentWait<WebDriver>(driver)

.withTimeout(Duration.ofSeconds(TimeOutInSecond))
.pollingEvery(Duration.ofMillis(PollingEveryInMilliSeccond)).ignoring(NoSuchFrameException.class);
return fwait;
}


public WebElement waitForElement(WebElement element,int TimeOutInSecond, int PollingEveryInMilliSeccond)
{
	Wait<WebDriver> fwait =new FluentWait<WebDriver>(driver);
	fwait.until(ExpectedConditions.visibilityOf(element));
 return element;
}
public void pageLoadTime(long timeout, TimeUnit unit)
{
	driver.manage().timeouts().pageLoadTimeout(timeout, unit);
	log.info("waiting for page to load for"+unit);
	log.info("page is loaded");
}

public void waitForElement(WebElement element,int TimeOutInSecond){
	log.info("waiting for page to load for");
	WebDriverWait wait=new WebDriverWait(driver,TimeOutInSecond);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}

}
