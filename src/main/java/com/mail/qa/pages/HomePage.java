package com.mail.qa.pages;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mail.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(linkText ="Contacts")
	WebElement contactlink;

	@FindBy(linkText ="Cloud")
	WebElement cloudlink;
	
	@FindBy(xpath="(//span[text()='E-mail'])[1]")
	WebElement userInbox;
	
	@FindBy(linkText="Premium")
	WebElement premiumlink;
	
	@FindBy(linkText ="Inbox")
	WebElement Inboxbox;
	
	@FindBy(xpath="//div[@class='panel panel-misc']")
	List<WebElement> footer;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}

	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage ClickonContactLink() {
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", contactlink);
		return new ContactsPage();
	}
	
	public CloudPage ClickonCloudLink() {
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", cloudlink);
		return new CloudPage();
}
	
	public boolean InboxboxTest() {
		return Inboxbox.isDisplayed();
	}
	
	public List<WebElement> footerList() {
		footer.size();
		return footer;
		
	}

	
}
