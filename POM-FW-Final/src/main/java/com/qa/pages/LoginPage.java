package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{

	// To instantiated Page Object, means all this variables will be init with driver..
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// page factory - OR(Object repository)
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text()='Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//a[contains(text(),'Classic CRM')]")
	WebElement ClassicCRMlink;
	
	
	// Actions
	
	// after clicking on login button we are landing to the HomePage so login method will return Homepage
	@Step("Login with username: {0} and password : {1} step...")
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	@Step("getting login page title..")
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	@Step("Validating CRM image on login page")
	public boolean validateCRMImage()
	{
		return ClassicCRMlink.isDisplayed();
	}
	
	
	
	
}
