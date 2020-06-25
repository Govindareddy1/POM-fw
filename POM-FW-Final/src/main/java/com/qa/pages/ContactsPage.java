package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement ContactsnameLabel;

	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(name="description")
	WebElement descriptiontext;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	public boolean verifyContactLable()
	{
		return ContactsnameLabel.isDisplayed();
	}
	
	// After click on New Conatcts button we need to fill the sheet over here
	
	public void createNewContacts(String ftname,String ltname,String status,String desc) throws InterruptedException
	{
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		
		driver.findElement(By.xpath("//div[@name='status']")).click();
		
		List<WebElement> myElements = driver.findElements(By.xpath("//div[@class='visible menu transition']//div[2]"));
		   for(WebElement e : myElements) {
		     if(e.getText().equalsIgnoreCase(status)) {
		         e.click();
		     }
		
		descriptiontext.sendKeys(desc);
		saveBtn.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")).isDisplayed();
		String createdusername=driver.findElement(By.xpath("//div[@class='ui header item mb5 light-black']")).getText();
		System.out.println("createdusername = "+createdusername);
		
	}
 }
	
}
