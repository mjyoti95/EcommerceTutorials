package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement registerFirstName;
	
	@FindBy(id="input-lastname")
	private WebElement registerLastName;
	
	@FindBy(id="input-email")
	private WebElement registeremail;
	
	@FindBy(id="input-telephone")
	private WebElement registertelephone;
	
	@FindBy(id="input-password")
	private WebElement registerpassword;
	
	@FindBy(id="input-confirm")
	private WebElement registerConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement registerClick;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement registerContinue;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsletterButton;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement alreadyRegisterEmailMessage;
	
	
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions 
	
	public void enterFirstName(String firstText)
	
	{
		registerFirstName.sendKeys(firstText);
		
	}
	public void enterlastName(String lastNameText)
	
	{
		registerLastName.sendKeys(lastNameText);
		
	}
	
	public void emailAddress(String EmailText)
	{
		registeremail.sendKeys(EmailText);
	}
	
	public void entertelephone(String telephoneText)
	{
		registertelephone.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText)
	{
		registerpassword.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText)
	{
		registerConfirmPassword.sendKeys(confirmPasswordText);
	}
	
	public void clickButton()
	{
		registerClick.click();
	}
	
	public void continueButton()
	{
		registerContinue.click();
	}
	
	public void newsLetterButtonClick()
	{
		newsletterButton.click();
	}
	
	public String alreadyregisterEmailMessage()
	{
		String warningMessage=alreadyRegisterEmailMessage.getText();
		return warningMessage;
	}
	
}
