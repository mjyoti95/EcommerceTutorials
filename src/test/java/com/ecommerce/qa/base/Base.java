package com.ecommerce.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.store.qa.utils.Utils;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public Base() //constructor
	{	
		prop= new Properties();
		File propFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecommerce\\config\\config.properties");
		
		dataprop =new Properties();
		File datapropFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecommerce\\testdata\\testdata.properties");
		try {
			FileInputStream fis2=new FileInputStream(datapropFile);
			dataprop.load(fis2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis=new FileInputStream(propFile);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public WebDriver initializeBrowser(String browserName)
	{
	
		
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		
		
		return driver;
	}

}
