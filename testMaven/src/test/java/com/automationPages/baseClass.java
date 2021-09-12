package com.automationPages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.browserFactory;
import com.utilities.configDataProvider;
import com.utilities.excelDataProvider;
import com.utilities.helper;

public class baseClass {

	public WebDriver driver;
	public excelDataProvider excel;
	public configDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void TestSuite()
	{
		excel = new excelDataProvider();
		config = new configDataProvider();
		
		//ExtentReporter extent = new ExtentReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM.html"));
		
		ExtentSparkReporter esr = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+ helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(esr);	
		
		
	}
	
	@BeforeClass
	public void startup()
	{
		try {
			driver = browserFactory.startBrowser(driver, config.getBrowser(), config.getURL());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
	}
	
	
	@AfterClass
	public void shutdown()
	{
		browserFactory.closeBrowser(driver);
		System.out.println("closeBrowser initiated!!!");
	}
	
	@AfterMethod
	public void shutdownmethod(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			//helper.captureScreenShot(driver);	
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenShot(driver)).build());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenShot(driver)).build());
		}
		
		report.flush();
	}
}
