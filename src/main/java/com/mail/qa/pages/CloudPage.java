package com.mail.qa.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mail.qa.base.TestBase;

public class CloudPage extends TestBase {
	
	@FindBy(xpath="//button[text()=' Cloud ']")
	WebElement cloudtext;
	
	@FindBy(xpath="//div[@class='cloud-sidebar__scroll']//cloud-folder-tree//div")
	List<WebElement> cloudscrollList;
	
	@FindBy(xpath="//button[@title='Upload']")
	WebElement upload;
	
	@FindBy(xpath="//span[text()='Upload from smartphone']")
	WebElement uploadFromSmartPhone;
	
	@FindBy(xpath ="//*[text()='core:DIALOG_CLOSE_BUTTON']")
	WebElement ClosePopup;


public CloudPage() {
	
	PageFactory.initElements(driver, this);
	
}

public boolean verifyCloudText() {
	return cloudtext.isDisplayed();
}

public List<WebElement> verifyCloudList() {
	cloudscrollList.size();
	return cloudscrollList;
}

public boolean verifyUploadButton() {
	upload.click();
	uploadFromSmartPhone.click();
	return ClosePopup.isDisplayed();
	
}

}
