package com.ecommerce.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.store.qa.utils.ExtentReporter;
import com.store.qa.utils.Utils;

public class MyListeners implements ITestListener{
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		
	 extentReport=	ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		 extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+"started executed");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.PASS, testName+"sucessfully executed");
		//System.out.println(testName+"sucessfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String destinationScreenshotPath= Utils.captureScreenShot(driver, testName);
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" got failed");
		
		//System.out.println(result.getThrowable());
		//System.out.println(testName+"got failed");
		//System.out.println("Screenshot taken");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"got skipped");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport =new File(pathOfExtentReport);
		//automatically open browser for extent report
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
}
