package com.automationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class freeCRMLoginPage {
	
	WebDriver driver;
	
	public freeCRMLoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(name="email") WebElement loginEmail;
	@FindBy(name="password") WebElement loginPassword;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginBtn;
	
	public void loginToCRM(String email, String password)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginBtn.click();
	}

}

