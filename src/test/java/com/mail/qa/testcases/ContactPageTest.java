package com.mail.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mail.qa.base.TestBase;
import com.mail.qa.pages.ContactsPage;
import com.mail.qa.pages.HomePage;
import com.mail.qa.pages.LoginPage;
import com.mail.qa.utilities.TestBaseUtil;

public class ContactPageTest extends TestBase{
	
	LoginPage loginpage;
	ContactsPage contactpage;
	HomePage homepage;
	TestBaseUtil testutil;
	
	String SheetName ="New ContactList";
	

	public ContactPageTest() {
		super();
	}
 
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  initilization();
	  loginpage = new LoginPage();
	  contactpage = new ContactsPage();
	  homepage = new HomePage();
	  testutil = new TestBaseUtil();
	  loginpage.LoginIDClick();
	  Thread.sleep(6000);
	  homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	  Thread.sleep(8000);
	  homepage.ClickonContactLink();
	  Thread.sleep(6000);
  }

  
  @Test(priority=3)
  public void VerifyContactTextTest() {
	  testutil.SwitchtoFrameincontacts();
	  boolean contactText =contactpage.Verifycontactstab();
	  Assert.assertTrue(contactText, "Contact text not showing");
	  
  }
  
  @Test(priority=2)
  public void SelectCheckboxTest() {
	  testutil.SwitchtoFrameincontacts();
	  String checkbox =contactpage.Selectcheckbox("shah, sheeja");
	  Assert.assertSame(checkbox, "shah, sheeja", "check box is selected");
	 	  
  }
  
 @Test(priority=1)
  public void MultipleCheckboxSelected() {
	  testutil.SwitchtoFrameincontacts();
	  contactpage.Selectcheckbox("shah, sheeja");
	  contactpage.Selectcheckbox("singh, sohan");
	  Assert.assertSame(contactpage.Selectcheckbox("shah, sheeja"), "shah, sheeja", "check box is selected");
	  Assert.assertSame(contactpage.Selectcheckbox("singh, sohan"), "singh, sohan", "check box is selected");
  }
  
 @DataProvider
  public Object[][] GetMailTestData() throws InvalidFormatException {
	  Object data[][]=testutil.getTestData(SheetName);
	  return data;
  }
  
  @Test(priority=4,dataProvider="GetMailTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String Emailselection,String Email,String company){
	  testutil.SwitchtoFrameincontacts();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactpage.createNewContactPage(title, firstName, lastName, Emailselection, Email, company);
		
	}
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
