package com.sv.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sv.base.TestBase;
import com.sv.pages.SVClickHerePage;



public class SVClickHereToBeginTest extends TestBase{
	SVClickHerePage svClickHerePage;
	
	public SVClickHereToBeginTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		svClickHerePage = new SVClickHerePage();
		svClickHerePage.ClickOn_ClickHereToBeginLink();
				
	}
	
	@Test
	public void Test(){
		System.out.println("test passed");
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
