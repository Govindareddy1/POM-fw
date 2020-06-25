package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		//login method is returning homepage
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	// verifying the home page title after login to the app
	@Test(priority=1)
	public void verifyHomepageTitile()
	{
		String homepageTitle=homepage.verifyhomepagetitle();
		Assert.assertEquals(homepageTitle, "Cogmento CRM", "Home page title is not matched");
	}
	
	// Verifying User name after login to the app
	@Test(priority=2)
	public void verifyUserName()
	{
		Assert.assertTrue(homepage.verifyUsernameLabel());
	}
	
	@Test(priority=3)
	public void verifyContactslinkTest()
	{
		contactpage=homepage.clickOnContactslink();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
