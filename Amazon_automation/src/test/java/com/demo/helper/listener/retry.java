package com.demo.helper.listener;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.demo.helper.logger.LoggerHelper;


public class retry implements IRetryAnalyzer{
	private int retryCount = 0;
	private int maxRetryCount =2;
	private Logger log=LoggerHelper.getLogger(retry.class);
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount) {
			log.info("Retring test "+result.getName()+" with a status "+getResultStatusName(result.getStatus())+" for the " +(retryCount+1)+" timess.");
			retryCount++;
			return true;
		}
		return false;
	}

public String getResultStatusName(int status) {
	String resultName = null;
	if(status == 1)
	{
		resultName = "SUCCESS";
		
	}
	if(status == 2) {
		resultName = "FAILURE";
	}
	if(status == 3) {
		resultName = "SKIP";
	}
	return resultName;
}


}
