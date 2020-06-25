package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.ExtentReporterNG;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends TestBase{
	
//	LoginPage loginpage;
//	HomePage homepage;
//	
	
	
	// to call super calss contructor we need to use below code
	//(this contructor will call the base class contructor)
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		logger.info("*********** Started login ************");
		loginpage=new LoginPage();	
		
		
	}

	@Test(priority=1, description="Verify login page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testcase Description: Verify login page title on login page")
	@Story("Story Name: Checking page title")
	public void logintitletest()
	{
		logger.info("*********** validating home page title ************");
		String title=loginpage.validateloginpagetitle();
		
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2,description="validating CRM image")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Testcase Description: validating CRM image on login page")
	@Story("Story Name: validating CRM image")
	public void CogmenCRMImageTest()
	{
		logger.info("*********** validating CRM image ************");
		boolean flag=loginpage.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3,description="Login into appliction test")
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Testcase Description: verify login into applicaiton with right credentials")
	@Story("Story Name: To check login functionality")
	public void loginTest()
	{
		logger.info("***********Logging to app using UN and PWD ************");
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
