package com.sv.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sv.base.TestBase;
import com.sv.commonfunctions.CommonFunction;
import com.sv.pages.SVClickHerePage;
import com.sv.pages.SVCustomerServicePage;
import com.sv.pages.SVHomePage;
import com.sv.pages.SVOperatorSignOnOPage;
import com.sv.pages.SVSignonPage;
import com.sv.pages.SVUATSearchPage;
import com.sv.utilities.TestUtil;
import com.sv.utilities.Xls_Reader;

public class SVUATSearchTest extends TestBase{
	
	public static Xls_Reader reader;
	TestUtil testUtil;
	SVSignonPage svSignonPage;
	SVClickHerePage svClickHerePage;
	SVOperatorSignOnOPage svOperatorSignOnOPage;
	SVHomePage svHomePage;
	SVCustomerServicePage svCustomerServicePage;
	SVUATSearchPage svUATSearchPage;
	CommonFunction commonFunction;
	
	
	
	public SVUATSearchTest(){
		super();
	}
	
	
	@BeforeSuite
	public void Setup(){
		initialization();
		reader = new Xls_Reader("C:\\Users\\e3009192\\Framework\\ServiceViewAutomationProject\\src\\main\\java\\com\\sv\\testdata\\ServiceViewSheet.xlsx");
		testUtil = new TestUtil();
		svClickHerePage = new SVClickHerePage();
		svOperatorSignOnOPage = new SVOperatorSignOnOPage();
		svSignonPage = new SVSignonPage();
		svHomePage = new SVHomePage();
		svUATSearchPage = new SVUATSearchPage();
		svCustomerServicePage = new SVCustomerServicePage();
		commonFunction = new CommonFunction();
		svClickHerePage.ClickOn_ClickHereToBeginLink();
		svSignonPage.ClickSignOnButton();
		svOperatorSignOnOPage.LoginToSV();
		svHomePage.ClickOn_CustomerServiceButton();
		svCustomerServicePage.locateAccount(reader.getCellData("Sheet1", 1, 2));
}
	
	
	@Test
	public void Test1(){
		svUATSearchPage.NavigateToUATSearchPage();
		commonFunction.SelectDDL(SVUATSearchPage.AnnualFeesDDL, "T - Fee Exempt 12M");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='CBXANYBLOCKEDACCTS_CHECKBOX']")).click();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
		
	}

}
