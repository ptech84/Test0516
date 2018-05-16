package com.sv.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sv.base.TestBase;
import com.sv.pages.SVClickHerePage;
import com.sv.pages.SVSignonPage;
import com.sv.utilities.TestUtil;

public class SVSignOnTest extends TestBase{
	ExtentReports extent;
	ExtentTest extentTest;
	SVSignonPage svSignonPage;
	SVClickHerePage svClickHerePage;
	static Logger log;
	
	public SVSignOnTest(){
		super();
	}
	
	
	@BeforeTest
	public void BeforeTest(){
		log = Logger.getLogger(SVSignOnTest.class);
		log.info("**********Before Test initiated********************");
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Name", "Praveen");
		extent.addSystemInfo("Version", "1.0");
		extent.addSystemInfo("OS", "Microsoft");
		extent.addSystemInfo("Role", "QA Automation Tester");
	}
	
	@AfterTest
	public void endReport(){
		log.info("**********end of Report initiated********************");
		//extent.flush();
		//extent.close();
	}
	
	
	
	
	@BeforeMethod
	public void Setup(){
		log.info("**********Before Method initiated********************");
		extentTest = extent.startTest("Setup");
		initialization();
		svClickHerePage = new SVClickHerePage();
		svSignonPage = new SVSignonPage();
		svClickHerePage.ClickOn_ClickHereToBeginLink();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	@Test
	public void ClickOnSignOnButton(){
		log.info("**********Click on SignOn button Test case initiated********************");
		extentTest = extent.startTest("ClickOnSignOnButton");				
		String title = svSignonPage.getPageTitle();
		Assert.assertEquals(title, "Service View Startp..");
		svSignonPage.ClickSignOnButton();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		log.info("**********end of test initiated********************");
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "Test Case Failed" + result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case Failed" + result.getThrowable());
			
			
			String screenshotpath = TestUtil.getSnapShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotpath));
			
			
			
		} else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case Passed" + result.getName());
		} else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case Skipped" + result.getName());
			
	}
	
		extent.endTest(extentTest);
		driver.quit();
	}
	
	public static String getSnapShot(WebDriver driver, String screenshotName) throws IOException{
		log.info("**********Get screenshot method initiated********************");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		     TakesScreenshot ts = (TakesScreenshot) driver;
		     File src = ts.getScreenshotAs(OutputType.FILE);
		    String dst = System.getProperty("user.dir") + "/FailedTestsScreenShots/" + screenshotName + dateName + ".png"; 
		    File fis = new File(dst);
		    FileUtils.copyFile(src, fis);
			return dst;
		  
		}


}