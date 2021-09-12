package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automationPages.baseClass;
import com.automationPages.freeCRMLoginPage;
import com.utilities.helper;

public class loginFreeCRM extends baseClass {
	
	
	
	@Test
	public void loginApp() throws InterruptedException
	{
		
		//logger = report.createTest("Login to FreeCRM");
		logger = report.createTest("Free CRM Login");
		freeCRMLoginPage loginPageObj = PageFactory.initElements(driver, freeCRMLoginPage.class);
		
		logger.info("Starting Application");
		
		loginPageObj.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));	
		
		logger.pass("Login Success");
		helper.captureScreenShot(driver);
						
	}
	
	@Test
	public void loginApp1() throws InterruptedException
	{
		
		//logger = report.createTest("Login to FreeCRM");
		logger = report.createTest("Another");
		//freeCRMLoginPage loginPageObj = PageFactory.initElements(driver, freeCRMLoginPage.class);
		
		logger.info("Starting Application");
		
		//loginPageObj.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));	
		
		logger.fail("Login fail");
		helper.captureScreenShot(driver);
						
	}
	
	

}
