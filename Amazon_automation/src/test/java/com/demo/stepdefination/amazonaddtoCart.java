package com.demo.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.pageObject.Mainpage;
import com.demo.pageObject.addToCart;
import com.demo.pageObject.productDescription;
import com.demo.pageObject.signInPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class amazonaddtoCart {
	WebDriver driver;
	signInPage sn;
	productDescription pd;
	Mainpage mn;
	addToCart ad;
	
	@Given("^Im on Amazon signinpage$")
	public void im_on_Amazon_signinpage() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:/downloads/chromedriver_win32 (1)/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.com");
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
		   mn.serachbox("samsung galaxy");
		   mn.serachimgclick();
	}

	@Then("^I select paricular product from list$")
	public void i_select_paricular_product_from_list() throws Throwable {
		 mn.mouseOverOnProduct(7);
	}

	@Then("^I add it to the cart$")
	public void i_add_it_to_the_cart() throws Throwable {
		System.out.println("kiiii");
	}

	@Then("^I asserting successful msg$")
	public void i_asserting_successful_msg() throws Throwable {
		 ad=new addToCart(driver);
			boolean status = ad.successmsg();
		   
	}

	@Then("^i click add to cart button$")
	public void i_click_add_to_cart_button() throws Throwable {
	   ad.additemcart();
	}

	@Then("^i delete particular product from the  cart$")
	public void i_delete_particular_product_from_the_cart() throws Throwable {
	    ad.mouseOverOnProductdelete(0);
	}


}
