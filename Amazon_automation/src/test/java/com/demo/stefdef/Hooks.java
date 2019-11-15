package com.demo.stefdef;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.demo.helper.supportMethods.FileRead;
import com.demo.runner.mainRunner;

import cucumber.api.Scenario;

import cucumber.api.java.Before;




/*public class Hooks {
	private static Boolean runOnce = false;

	@Before
	public void beforeAll() throws FileNotFoundException, IOException, InterruptedException {
		if (!runOnce) {
			mainRunner.config = FileRead.readProperties();
			System.out.println("frrom main"+mainRunner.config);
		}
	}
	
	/*@Before
	public void before(Scenario scenario) {
		mainRunner.scenario = scenario;
	}

	

}*/