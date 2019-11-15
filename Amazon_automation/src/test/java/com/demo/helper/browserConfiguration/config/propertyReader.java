package com.demo.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.demo.helper.browserConfiguration.BrowserType;
import com.demo.helper.resourceHelper.resourceHelper;



public class propertyReader implements ConfigHelper{
	private static FileInputStream file;
	public static Properties OR;
	public propertyReader()
	{
		String filepath = resourceHelper.getResourcePath("/src/test/resources/configfile/config.properties");
		try {
			 file = new FileInputStream(new File(filepath));
			 OR=new Properties();
			
				OR.load(file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("pageloadtime"));	}

	public BrowserType getBrowserType() {
		// TODO Auto-generated method stub
		return BrowserType.valueOf(OR.getProperty("Browsertype"));
	}

	public String getUrl() {
		
		return OR.getProperty("applicationUrl");
	}

	public String getuserName() {
		
		return OR.getProperty("userName");
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return OR.getProperty("password");
	}

	public String getnusername() {
		// TODO Auto-generated method stub
		return OR.getProperty("nusername");
	}

	public String getnpassword() {
		// TODO Auto-generated method stub
		return OR.getProperty("npassword");
	}

}
