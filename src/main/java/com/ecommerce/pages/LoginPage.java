package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailAddressFiled;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddress(String emailtext)
	{
		emailAddressFiled.sendKeys(emailtext);
	}
	public void enterPassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	
	}
	public void clickOnButton()
	{
		loginButton.click();
	}
	
}
