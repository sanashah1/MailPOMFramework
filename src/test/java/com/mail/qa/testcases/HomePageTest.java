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

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestBaseUtil testutil;
	ContactsPage contactspage;
	CloudPage cloudpage;
	
	
	public HomePageTest() {
		super();
	}

  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  initilization();
	  loginpage = new LoginPage();
	  testutil = new TestBaseUtil();
	  contactspage = new ContactsPage();
	  cloudpage = new CloudPage();
	  loginpage.LoginIDClick();
	  homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	  Thread.sleep(6000); //check with nikul
  }
	
 @Test(priority =1)
  public void VerifyHomePageTitleTest() {
	 String homepageTitle = homepage.verifyHomepageTitle();
	 Assert.assertEquals(homepageTitle, "Free Email Addresses: Web based and secure Email - mail.com", "HomePage title is not correct");
  }
  
  
 @Test(priority =2)
  
  public void VerifyInboxboxLinkTest() {
	  testutil.SwitchtoFrameinmail();
	  boolean inboxboxlink = homepage.InboxboxTest();
	  Assert.assertTrue(inboxboxlink, "Frame Inbox is not verified");
  }
  
 @Test (priority =3)
  public void VerifyContactslinkTest() {
	  contactspage =homepage.ClickonContactLink();
  }
  
  @Test(priority =4)
  public void VerifyCloudLinkTest() {
	  cloudpage =homepage.ClickonCloudLink();
  }
  
  @Test(priority =5)
  public void VerifyFooterList() {
	  testutil.SwitchtoFrameinmail();
	  List<WebElement> footer =homepage.footerList();
	  Assert.assertTrue(footer.size()>0, "Footer List is not verified");
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
