package com.utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class helper {
	
	public static String captureScreenShot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshot/FreeCRM_"+ getCurrentDateTime() + ".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to take screenshot" +e.getMessage());
		}
		
		return screenshotPath;
		
	}
	
	public static String getCurrentDateTime()
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
		
	}

}
