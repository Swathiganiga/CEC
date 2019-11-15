package com.demo.stefdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.demo.configuration.ConfigFileReader;
import com.demo.configuration.setup;
import com.demo.helper.browserConfiguration.config.objectReader;
import com.demo.helper.excel.ExvelHelpers;
import com.demo.helper.new1.DriverFactorya;
import com.demo.helper.resourceHelper.resourceHelper;
import com.demo.helper.webDriver.Driver;
import com.demo.pageObject.Mainpage;
import com.demo.pageObject.addToCart;
import com.demo.pageObject.productDescription;
import com.demo.pageObject.signInPage;
import com.demo.runner.mainRunner;
import com.demo.testbase.TestBase;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class amazonaddtoCart  {
	
	 WebDriver  driver;
	signInPage sn;
	productDescription pd;
	Mainpage mn;
	addToCart ad;
	ConfigFileReader configFileReader;
	@Given("^Im on Amazon signinpage$")
	public void im_on_Amazon_signinpage() throws Throwable {
		configFileReader= new ConfigFileReader();
		//System.setProperty("webdriver.chrome.driver","E:/downloads/chromedriver_win32 (1)/chromedriver.exe");
		// driver = new ChromeDriver();
		// driver.manage().window().maximize();
		 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //driver = Driver.getCurrentDriver();
		 //System.out.println(driver);
		DriverFactorya f=new DriverFactorya ();
		String var = configFileReader.getBrowser();
		System.out.println(var);
		//driver=f.setup(var);
		driver=f.setup(var);
		//setup s=new setup();
		//s.setconfog(driver);
		 //driver.get("https://www.amazon.com");
		
		
	}

	@When("^I enter valid username and password$")
	public void i_enter_valid_username_and_password() throws Throwable {
		 sn=new signInPage(driver);
		   sn.mouseOverOnProduct();
		   sn.clicksignin();
		   sn.enteremail("swathiganiga98@gmail.com");
		   sn.enterContinue();
		   sn.enterpassword("2013swathi123");
		   sn.enterSubmit();
	}

	@Then("^I search  product$")
	public void i_search_product() throws Throwable {
		 mn=new Mainpage(driver);
		   mn.serachbox("samsung a10e case");
		   mn.serachimgclick();
	}

	@Then("^I select paricular product from list$")
	public void i_select_paricular_product_from_list() throws Throwable {
		 mn.mouseOverOnProduct(9);
	}

	@Then("^I add it to the cart$")
	public void i_add_it_to_the_cart() throws Throwable {
	   pd=new productDescription(driver);
	   pd.addtocarts();
	}

	@Then("^I asserting successful msg$")
	public void i_asserting_successful_msg() throws Throwable {
		 ad=new addToCart(driver);
			boolean status = ad.successmsg();
		   System.out.println(status);
		   driver.close();
	}

	@Then("^i click add to cart button$")
	public void i_click_add_to_cart_button() throws Throwable {
		 ad=new addToCart(driver);
		ad.additemcart();
	}

	@Then("^i delete particular product from the  cart$")
	public void i_delete_particular_product_from_the_cart() throws Throwable {
	    ad.mouseOverOnProductdelete(0);
	    driver.close();
	}
	@When("^I input username and passwords with index \"([^\"]*)\"$")
	public void i_input_username_and_passwords_with_index(int nrow) throws Throwable {
		
		   ExvelHelpers x=new ExvelHelpers();
		   String excelPath=resourceHelper.getResourcePath("/src/test/resources/configfile/testdata.xlsx");
	        String[] dataSet = x.getdataString(excelPath,nrow);
			 System.out.println("dataSet "+dataSet[0]);
			 System.out.println("dataSet "+dataSet[1]);
			 sn=new signInPage(driver);
			   sn.mouseOverOnProduct();
			   sn.clicksignin();
			   sn.enteremail(dataSet[0]);
			   sn.enterContinue();
			   sn.enterpassword(dataSet[1]);
			   sn.enterSubmit();
			   driver.close();
			
	}


}
