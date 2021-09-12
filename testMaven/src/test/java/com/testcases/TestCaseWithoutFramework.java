package com.testcases;

import java.util.concurrent.TimeUnit;

//import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
	
	@Test
	
	public void test1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\609061884\\OneDrive - BT Plc\\Documents\\Projects\\testMaven\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement logInBtn = driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
        logInBtn.click();
        driver.quit();
		
	}

}
