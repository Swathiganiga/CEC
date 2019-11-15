package com.demo.helper.browserConfiguration.config;

import com.demo.helper.browserConfiguration.BrowserType;

public interface ConfigHelper {
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getuserName();
	public String getPassword();
	public String getnusername();
	public String getnpassword();
}
