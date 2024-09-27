package com.ecommerce.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.SearchPage;
import com.ecommerce.qa.base.Base;

public class SearchTest extends Base {
	public WebDriver driver;
	public SearchTest()//constructor call
	{
		super();//super class constructor, base is the super class constructor
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowser(prop.getProperty("browser"));
		
	}
	
		@Test(priority=1)
		public void verifySearchWithValidProduct()
		{	
			
			HomePage homepage = new HomePage(driver);
			homepage.enterSearchedElement("HP");
			
			homepage.searchButtonClicked();
			SearchPage searchPage= new SearchPage(driver);
			Assert.assertTrue(searchPage.searchedItemDisplayed());
		
			}
		@Test(priority=2)
		public void verifySearchWithInValidProduct()
		{	
			HomePage homepage = new HomePage(driver);
			homepage.enterSearchedElement("Honda");
			
			homepage.searchButtonClicked();
			
			SearchPage searchPage= new SearchPage(driver);
			String actualMesage=searchPage.wrongItemSearchedMessage();
			//Assert.assertEquals(actualMesage,"There is no product that matches the search criteria.","No product in search");
			//above line is correct
			//to fails test
			
			Assert.assertEquals(actualMesage,"abcd","No product in search"); 
			
			}
		
		@Test(priority=3,dependsOnMethods= {"verifySearchWithInValidProduct"})
		public void verifySearchWithOutAnyValidProduct()
		{
			HomePage homepage = new HomePage(driver);
			homepage.enterSearchedElement("");
			
			homepage.searchButtonClicked();
			
			SearchPage searchPage= new SearchPage(driver);
			String actualMesage=searchPage.wrongItemSearchedMessage();
			Assert.assertEquals(actualMesage,"There is no product that matches the search criteria.","No product in search"); 
			
			
			}
		
		
}
