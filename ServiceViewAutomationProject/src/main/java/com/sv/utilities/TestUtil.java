package com.sv.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sv.base.TestBase;
import com.sv.pages.SVAuthISOSummaryPage;

public class TestUtil extends TestBase{
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest extentTest;
	public static Xls_Reader reader;
	public static int Implicit_Wait=10;
	public static int Page_Load_Timeouts=10;
	
	
	public static ArrayList<Object[]> getDataFromXcel(){
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try{
		reader = new Xls_Reader("C:\\Users\\e3009192\\Framework\\ServiceViewAutomationProject\\src\\main\\java\\com\\sv\\testdata\\ServiceViewSheet.xlsx");
	} catch (Exception e) {
		e.printStackTrace();
	}
				
		int rowCount = reader.getRowCount("Sheet1");
	
		for(int i=2; i <=rowCount;i++){
			String acctNo = reader.getCellData("Sheet1", 1, i);
			String time = reader.getCellData("Sheet1", 3, i);
			Object[] data = {acctNo, time};
			myData.add(data);
			
			
		}
		
		return myData;
		}

	// generate screenshot method
	
		public static String getSnapShot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			     TakesScreenshot ts = (TakesScreenshot) driver;
			     File src = ts.getScreenshotAs(OutputType.FILE);
			    String dst = System.getProperty("user.dir") + "/FailedTestsScreenShots/" + screenshotName + dateName + ".png"; 
			    File fis = new File(dst);
			    FileUtils.copyFile(src, fis);
			    return dst;
			}
	
	
	
		// generate test reports
		public void ExtentReport(ITestResult result) throws IOException{
			
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
	
}}
