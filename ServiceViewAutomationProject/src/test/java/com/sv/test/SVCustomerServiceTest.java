package com.sv.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sv.base.TestBase;
import com.sv.pages.SVClickHerePage;
import com.sv.pages.SVCustomerServicePage;
import com.sv.pages.SVHomePage;
import com.sv.pages.SVOperatorSignOnOPage;
import com.sv.pages.SVSignonPage;
import com.sv.utilities.TestUtil;

public class SVCustomerServiceTest extends TestBase{
	TestUtil testUtil;
	SVSignonPage svSignonPage;
	SVClickHerePage svClickHerePage;
	SVOperatorSignOnOPage svOperatorSignOnOPage;
	SVHomePage svHomePage;
	SVCustomerServicePage svCustomerServicePage;
	
	public SVCustomerServiceTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		testUtil = new TestUtil();
		svClickHerePage = new SVClickHerePage();
		svOperatorSignOnOPage = new SVOperatorSignOnOPage();
		svSignonPage = new SVSignonPage();
		svHomePage = new SVHomePage();
		svCustomerServicePage = new SVCustomerServicePage();
		svClickHerePage.ClickOn_ClickHereToBeginLink();
		svSignonPage.ClickSignOnButton();
		svOperatorSignOnOPage.LoginToSV();
		svHomePage.ClickOn_CustomerServiceButton();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public void LocateAccount(String acctNo){
		svCustomerServicePage.locateAccount(acctNo);
		
	}
		
	@Test(dataProvider="getDataFromExcel")
	public void NavigateToAuthInquiryPage(String acctNo){
		svCustomerServicePage.locateAccount(acctNo);
		svCustomerServicePage.NavigateToAuthInquiryPage();
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> getDataFromExcel(){
		ArrayList<Object[]> dataList = TestUtil.getDataFromXcel();
		return dataList.iterator();
		
		
	}
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	

}
