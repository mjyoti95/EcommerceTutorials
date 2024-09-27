package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccessPageHeading;
	
	
	public AccountSuccesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String retreiveAccountSuccessPage()
	{
		String accountMessage = accountSuccessPageHeading.getText();
		return accountMessage;
	}

}
