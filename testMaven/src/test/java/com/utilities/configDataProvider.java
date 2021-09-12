package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {
	
	Properties pro;
	public configDataProvider()
	{
		File src = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to read the file" +e.getMessage());
		} 
	}
	
//	public getDataFromConfig()
//	{
//		
//	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getURL()
	{
		return pro.getProperty("URL");
	}

}
