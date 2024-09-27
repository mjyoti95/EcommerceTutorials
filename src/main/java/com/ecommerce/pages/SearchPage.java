package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement searchedItemDisplayed;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement wrongSearchElementMessage;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchedItemDisplayed()
	{
		boolean searchedDisplaystatus =searchedItemDisplayed.isDisplayed();
		return searchedDisplaystatus;
	}
	
	public String wrongItemSearchedMessage()
	{
		String searchedwarningMessage=wrongSearchElementMessage.getText();
		return searchedwarningMessage;
	}
}
