package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslnik;
	
	// New contacts button
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactsbtn;
	
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslnik;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement taskslnik;
	
	// first we need to verify home page titile after login to app
	public String verifyhomepagetitle()
	{
		return driver.getTitle();
	}

	public boolean verifyUsernameLabel()
	{
		return usernameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactslink()
	{
		contactslnik.click();
		// after clcik on contact link it will navigate to contacts page so we are returning the conatctpage.
		return new ContactsPage();
	}
	
	public DealsPage clickOndealslink()
	{
		dealslnik.click();
		// after clicking on contact link it will navigate to deals page so we are returning the dealspage.
		return new DealsPage();
	}
	public TasksPage clickOntasklink()
	{
		contactslnik.click();
		// after clicking on Tasks link it will navigate to contacts page so we are returning the taskpage.
		return new TasksPage();
	}
	
	public void clickOnNewContactsButton()
	{
		newContactsbtn.click();
		// Next go to ContactsPage and fill the form and submit
		
	}
	
}
