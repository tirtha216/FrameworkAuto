package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserFactory {
	
	public static WebDriver startBrowser(WebDriver driver, String browserName, String appURL) throws InterruptedException
	{
		if (browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();						
		}
		else
		{
			System.out.println("Sorry, browser is not supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);	
		Thread.sleep(10000);
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();		
	}
	
	/*public static WebDriver startApp(WebDriver driver, String appURL)
	{
		driver.get(appURL);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}*/

}
