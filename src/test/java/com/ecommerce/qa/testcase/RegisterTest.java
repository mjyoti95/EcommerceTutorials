package com.ecommerce.qa.testcase;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.pages.AccountSuccesPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.qa.base.Base;
import com.store.qa.utils.Utils;

public class RegisterTest extends Base {
	
public WebDriver driver;
public RegisterTest()//constructor call
{
	super();//super class constructor, base is the super class constructor
}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@BeforeMethod
	public void setup() {
		driver=initializeBrowser(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyaccount();
		homePage.clickOnRegisterButton();
		
	}
	@Test(priority=1)
	public void verifyRegisterAnAccountWithMandatoryFields()
	{
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName("Mono");
		registerPage.enterlastName("Goswami");
		registerPage.emailAddress(Utils.generateEmailTimeStamp());
		registerPage.entertelephone("123456791");
		registerPage.enterPassword("Test@123");
		registerPage.enterConfirmPassword("Test@123");
		registerPage.clickButton();
		registerPage.continueButton();
		
		AccountSuccesPage accountsuccess= new AccountSuccesPage(driver);
		
		String actualwarningMessage= accountsuccess.retreiveAccountSuccessPage();
		
		Assert.assertEquals(actualwarningMessage, "Your Account Has Been Created!");
		
		}
	@Test(priority=2)
	public void verifyRegisterAnAccountWithAllFields()
	{	
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName("Mono");
		registerPage.enterlastName("Goswami");
		registerPage.emailAddress(Utils.generateEmailTimeStamp());
		registerPage.entertelephone("123456791");
		registerPage.enterPassword("Test@123");
		registerPage.enterConfirmPassword("Test@123");
		registerPage.newsLetterButtonClick();
		registerPage.clickButton();
		registerPage.continueButton();
		
		AccountSuccesPage accountsuccess= new AccountSuccesPage(driver);
		
		String actualwarningMessage= accountsuccess.retreiveAccountSuccessPage();
		
		Assert.assertEquals(actualwarningMessage, "Your Account Has Been Created!");
		
		
		
		
	

}
	@Test(priority=3)
	public void verifyRegisterWIthExistingEmail()
	{	
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName("Mono");
		registerPage.enterlastName("Goswami");
		registerPage.emailAddress("monobabai.goswami@gmail.com");
		registerPage.entertelephone("123456791");
		registerPage.enterPassword("Test@123");
		registerPage.enterConfirmPassword("Test@123");
		registerPage.newsLetterButtonClick();
		registerPage.clickButton();
		registerPage.continueButton();
		
		String actualwarningMessage=registerPage.alreadyregisterEmailMessage();
		Assert.assertTrue((actualwarningMessage).contains("Warning: E-Mail Address is already registered!"));
		
		
		
		
		
	}
}
