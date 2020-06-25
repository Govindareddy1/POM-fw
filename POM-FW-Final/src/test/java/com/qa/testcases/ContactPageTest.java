package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	String sheetName="Contacts";
	
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		//login method is returning homepage
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		// click on conntacts link and store into conatctpage for further use
		contactpage=homepage.clickOnContactslink();
		Thread.sleep(5000);
	}

	
	// Verifying Conatcts label
	@Test(priority=1)
	public void verifyContactlabelname()
	{
		Assert.assertTrue(contactpage.verifyContactLable(),"Contact label is unable to find");
	}
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getTestData")
	public void validatecreateNewContact(String fname,String lname,String status,String description) throws InterruptedException
	{
		// first we have to click on new Contacts button to go to new page to fill the form
		
		homepage.clickOnNewContactsButton();
		Thread.sleep(5000);
		//contactpage.createNewContacts("Heidy", "Will","New","New automation testing");
		contactpage.createNewContacts(fname,lname,status,description);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
