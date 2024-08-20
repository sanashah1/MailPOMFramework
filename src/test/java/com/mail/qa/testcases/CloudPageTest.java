package com.mail.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mail.qa.base.TestBase;
import com.mail.qa.pages.CloudPage;
import com.mail.qa.pages.ContactsPage;
import com.mail.qa.pages.HomePage;
import com.mail.qa.pages.LoginPage;
import com.mail.qa.utilities.TestBaseUtil;

public class CloudPageTest extends TestBase{
	
	LoginPage loginpage;
	ContactsPage contactpage;
	HomePage homepage;
	TestBaseUtil testutil;
	CloudPage cloudpage;
	
	public CloudPageTest() {
		super();
	}
 
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  initilization();
	  loginpage = new LoginPage();
	  contactpage = new ContactsPage();
	  homepage = new HomePage();
	  testutil = new TestBaseUtil();
	  cloudpage = new CloudPage();
	  loginpage.LoginIDClick();
	  homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	  Thread.sleep(6000);
	  homepage.ClickonCloudLink();
	  Thread.sleep(6000);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @Test(priority=1)
  public void VerifyCloudTextTest() {
	  testutil.SwitchtoFrameinCloud();
	  boolean cloudText =cloudpage.verifyCloudText();
	  Assert.assertTrue(cloudText, "Cloud Text is not dispalyed");
  }
  
  @Test(priority=2)
  public void VerfiyCloudListTest() {
	  testutil.SwitchtoFrameinCloud();
	  List<WebElement> list =cloudpage.verifyCloudList();
	  Assert.assertTrue(list.size()>0, "list is not dispalyed");
  }
  
  @Test(priority =3)
  public void VerifyUploadSmartPhoneTest() {
	  testutil.SwitchtoFrameinCloud();
	  boolean CloseupBoxGenerated =cloudpage.verifyUploadButton();
	  Assert.assertTrue(CloseupBoxGenerated, "Close PopUp box is not displayed");
  }
  

  
}
