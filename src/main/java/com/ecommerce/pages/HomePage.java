package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchElement;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement clickOnSearchButton;
	
	
	
	public void clickOnRegisterButton()
	{
		registerOption.click();
	}
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Actions
	public void clickOnMyaccount()
	{
		myAccountDropMenu.click();
	}
	public void selectLoginOption()
	{
		loginOption.click();
	}
	
	public void enterSearchedElement(String searchedText)
	{
		searchElement.sendKeys(searchedText);
	}
	
	public void searchButtonClicked()
	{
		clickOnSearchButton.click();
	}
	
	
	

}
