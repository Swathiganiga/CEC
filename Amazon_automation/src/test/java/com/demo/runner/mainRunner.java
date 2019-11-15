package com.demo.runner;
import java.util.Map;

import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//java//com//demo//feature",
glue= {"com.demo.stefdef"},
plugin = {"json:target/cucumber-json.json"},
tags= {"@test3"}
		)
public class mainRunner    {
	public static Map<String, String> config;
	//public static Scenario scenario;
}
