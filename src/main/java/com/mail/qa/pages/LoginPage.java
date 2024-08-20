package com.mail.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mail.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//create Page factory objects OR object repository

	@FindBy(id ="login-button")
	WebElement loginID;
	
	@FindBy(name ="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name ="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath ="//button[@class='btn btn-block login-submit']")
	WebElement loginbtn;
	
	@FindBy(id ="signup-button")
	WebElement Signupbtn;
	
	@FindBy(xpath="//img[@alt='mail.com logo']")
	WebElement maillogo;
	
	//initilizing page objects
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions

	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateMailLogo() {
		return maillogo.isDisplayed();
	}
	
	public void LoginIDClick() {
		loginID.click();
	}
	
	public HomePage login(String us,String ps) {
		username.sendKeys(us);
		password.sendKeys(ps);
		//loginbtn.click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", loginbtn);
	
	return new HomePage();

	}
}
