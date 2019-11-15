package com.demo.testScript;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.demo.helper.browserConfiguration.config.objectReader;
import com.demo.helper.logger.LoggerHelper;
import com.demo.pageObject.Mainpage;
import com.demo.pageObject.addToCart;
import com.demo.pageObject.productDescription;
import com.demo.pageObject.signInPage;




public class testcase {
	WebDriver driver;
	private Logger log=LoggerHelper.getLogger(testcase.class);
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication() {
		 System.setProperty("webdriver.chrome.driver","E:/downloads/chromedriver_win32 (1)/chromedriver.exe");
	       driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.com");
		   
		signInPage sn=new signInPage(driver);
	  sn.mouseOverOnProduct();
	  sn.clicksignin();
	  sn.enteremail("swathiganiga98@gmail.com"); 
          sn.enterContinue();
          sn.enterpassword("2013swathi123");
          sn.enterSubmit();
          Mainpage mn=new Mainpage(driver);
          mn.serachbox("samsung galaxy");
          mn.serachimgclick();
        // mn.trials();
          //System.out.println("swathi-----"+objectReader.reader.getExplicitWait());
         mn.mouseOverOnProduct(9);
          productDescription pd=new productDescription(driver);
          pd.addtocarts();
          addToCart ad=new addToCart(driver);
          ad.clickcart();
          ad.mouseOverOnProductdelete(0);
          
          
		
	}
	
	

}
