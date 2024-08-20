package com.mail.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mail.qa.base.TestBase;
import com.mail.qa.pages.HomePage;
import com.mail.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	//this is used to run the properties file
public LoginPageTest() {
		super();
	}

@BeforeMethod
public void Setup() {
	initilization();
	loginpage = new LoginPage();
}

@AfterMethod
public void closebrowser() {
	driver.quit();
}

@Test(priority =1)
  public void verifyTitlepageTest() {
	String title = loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "Free email accounts with mail.com | Log in here or register today");
  }

@Test(priority =2)
public void MailLogoTest() {
	boolean logo =loginpage.validateMailLogo();
	Assert.assertTrue(logo);
}

@Test(priority =3)
public void LoginTest() {
	loginpage.LoginIDClick();
	homepage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
}
}
