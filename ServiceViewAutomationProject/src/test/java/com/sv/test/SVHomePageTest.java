package com.sv.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sv.base.TestBase;
import com.sv.pages.SVClickHerePage;
import com.sv.pages.SVHomePage;
import com.sv.pages.SVOperatorSignOnOPage;
import com.sv.pages.SVSignonPage;

public class SVHomePageTest extends TestBase {


	SVSignonPage svSignonPage;
	SVClickHerePage svClickHerePage;
	SVOperatorSignOnOPage svOperatorSignOnOPage;
	SVHomePage svHomePage;
	
	public SVHomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		svClickHerePage = new SVClickHerePage();
		svOperatorSignOnOPage = new SVOperatorSignOnOPage();
		svSignonPage = new SVSignonPage();
		svHomePage = new SVHomePage();
		svClickHerePage.ClickOn_ClickHereToBeginLink();
		svSignonPage.ClickSignOnButton();
		svOperatorSignOnOPage.LoginToSV();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void ClickOnCustomerServiceModule(){
		
		svHomePage.ClickOn_CustomerServiceButton();
		
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
}
