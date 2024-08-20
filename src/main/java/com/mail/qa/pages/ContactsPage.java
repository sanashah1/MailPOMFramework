package com.mail.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mail.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath ="//div[@class='toolarea  filter']/button[text()='Contacts']")
	WebElement contactstab;
	
	@FindBy(name ="select")
	WebElement selectcheckbox;
	
	@FindBy(xpath="//button[text()='New Contact']")
	WebElement newcontact;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="name")
	WebElement lastName;
	
	@FindBy(name="classifier")
	WebElement select;
	
	@FindBy(xpath="//input[@placeholder='E-mail']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='button primary normal']")
	WebElement savebutton;
	
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}

	public boolean Verifycontactstab() {
		return contactstab.isDisplayed();
	}
	
	public String Selectcheckbox(String title) {
		driver.findElement(By.xpath("//tbody[@class='entries']//tr[@class='entry contact ui-draggable ui-draggable-handle ui-droppable']"
				+ "//td[@title='"+title+"']")).click();
		return title;
			
	}
	
	
	public void createNewContactPage(String titl,String fstName,String lstName,String sltofemail,String emil,String comp) {
		
		newcontact.click();
		
		title.sendKeys(titl);
		firstName.sendKeys(fstName);
		lastName.sendKeys(lstName);
		
		Select s = new Select(select);
		s.selectByVisibleText(sltofemail);
		
		email.sendKeys(emil);
		company.sendKeys(comp);
		
		savebutton.click();
		
	}

	
}
