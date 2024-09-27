package com.ecommerce.qa.testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.pages.AccountPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.qa.base.Base;
import com.store.qa.utils.Utils;

public class loginTest extends Base{
	public WebDriver driver;
	
	public loginTest()//constructor call
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
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyaccount();
		homePage.selectLoginOption();
		
		
	}
	
	@Test(priority=1,dataProvider="validCredentialSupplier")
	public void verifyloginWithValidCredentials(String email,String password)
	{
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		//driver.findElement(By.linkText("Login")).click();
		loginPage.enterPassword(password);
		
		loginPage.clickOnButton();
		AccountPage accountPage= new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplaystatusisDisplayed());
		
		
		}
	@DataProvider(name="validCredentialSupplier")
	public Object [][] supplyTestData()
	{
		Object[][]	 data = Utils.getTestDataFromExcel("Login");
		return data;
	}
	@Test(priority=2)
	public void verifyloginWithInValidCredentials()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(Utils.generateEmailTimeStamp());
		//driver.findElement(By.linkText("Login")).click();
		loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginPage.clickOnButton();
	
		
		
		//String ActualWarningMessage= driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]]")).getText();
		//String expectedwarningmessage = "Warning: No match for E-Mail Address and/or Password.";
		
		//Assert.assertTrue(ActualWarningMessage.contains(expectedwarningmessage), "Expected Warning message is not diplayed ");
		
		
	}
	
	@Test(priority=3)
	public void verifyloginWithInValidEmanilAndValidPassword()
	{
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(Utils.generateEmailTimeStamp());
		
		loginPage.enterPassword("Testaa@123");
		loginPage.clickOnButton();
				
				
				
	}
	@Test(priority=4)
	public void verifyloginWithValidEmanilAndInValidPassword()
	{	
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("email"));
		
		loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginPage.clickOnButton();
		
		
		
		
		
	}
		
		
}

