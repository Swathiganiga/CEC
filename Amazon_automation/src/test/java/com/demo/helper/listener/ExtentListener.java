package com.demo.helper.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class ExtentListener implements ITestListener {
	
	public static ExtentReports extent;
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
	test.log(Status.INFO, result.getName()+" started");
	Reporter.log(result.getMethod().getMethodName()+" test passed");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO, result.getName()+" passed");
		Reporter.log(result.getMethod().getMethodName()+" test started");
	}

	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName()+" this failed"+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName()+" test skipped"+result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//extent= extentManager.getInstancce();
		//test=extent.createTest(context.getName());
		Reporter.log(context.getName()+" this test started...");
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		Reporter.log(context.getName()+" this test finished...");
	}

}
