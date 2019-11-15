package com.demo.helper.assertion;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.demo.helper.logger.LoggerHelper;


public class assertionHelper {
private static Logger log=LoggerHelper.getLogger(assertionHelper.class);
	
	public static void verifyText(String s1,String s2) {
		log.info("verifying text "+s1+" with" +s2);
		Assert.assertEquals(s1, s2);
	}
	
	public static void makeTrue() {
		log.info("makig script pass");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String message) {
		log.info("makig script pass"+message);
		Assert.assertTrue(true);
	}
	public static void verifyFalse() {
		log.info("makig script fail");
		Assert.assertTrue(false);
	}
	
	public static void verifyFalse(String message) {
		log.info("makig script fail"+message);
		Assert.assertTrue(false);
	}
	
	public static void verifyTrue(boolean status)
	{
		Assert.assertTrue(status);
	}
	
	public static void verifyFalse(boolean status)
	{
		Assert.assertFalse(status);
	}
	public static void verifyNull(String s1)
	{
		log.info("verify object is null...");
		Assert.assertNull(s1);
	}
	public static void verifyNotNull(String s1)
	{
		log.info("verify object is not null...");
		Assert.assertNotNull(s1);
	}
	public static void updatestatus(boolean status){
		if(status) {
			pass();
		}
		else
		{
			fail();
			
		}
	}
	public static void pass() {
		Assert.assertTrue(true);
	}
	public static void fail()
	{
		Assert.assertTrue(false);
	}

}
