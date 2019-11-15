package com.demo.helper.resourceHelper;

public class resourceHelper {

	public static String getResourcePath(String path)
	{
		String basePath =System.getProperty("user.dir");
		return basePath+path;
	}
	//public static void main(String[] args) {
		//String path=resourceHelper.getResourcePath("src/main/resources/configfile/log4j.properties");
		//System.out.println(path);
	//}
	}
