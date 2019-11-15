package com.demo.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExvelHelpers {
public String[] getdataString (String excellocation,int rc) throws IOException
{
	String username;
	String password;
	int rowcount = 0;

		FileInputStream file=new FileInputStream(new File(excellocation));
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("login");
      rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		//for(int row=rc;row<rowcount;)
		//{
			XSSFRow current_rw = sheet.getRow(rc	);
			 username=current_rw.getCell(0).getStringCellValue();
			// getusername(username);
			System.out.println("username "+username);
             password=current_rw.getCell(1).getStringCellValue();
			//getpassword(password);
			System.out.println("passs "+password);
			String[] ans = new String[2];
			ans[0]=username;
			ans[1]=password;
			
		//}
	

	return ans;
	
}
public String getusername(String usr){
    return usr;
}

public String getpassword(String pass){
    return pass;
}




}
