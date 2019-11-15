package com.demo.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.demo.helper.resourceHelper.resourceHelper;



public class LoggerHelper {
	
private static boolean root = false;
public static Logger getLogger(Class cls)
{
	if(root)
	{
		return Logger.getLogger(cls);
	}
	//PropertyConfigurator.configure("E:/PAGE OBJECT MODEL/UI_Framework/src/main/resources/configfile/log4j.properties");
	PropertyConfigurator.configure(resourceHelper.getResourcePath("/src/test/resources/configfile/log4j.properties"));
	root= true;
    return Logger.getLogger(cls);
}

public static void main(String[] args) {
	Logger log=LoggerHelper.getLogger(LoggerHelper.class);

}
}
