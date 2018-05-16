package com.sv.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessBrowser {
	WebDriver driver;
	
	
	@Test
	public void Testcase(){
		
	
		//driver = new HtmlUnitDriver();

	
	driver.manage().window().maximize(); //maximize window
	driver.manage().deleteAllCookies(); //delete all the cookies
	
	//dynamic wait
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("http://www.freecrm.com");
	
	System.out.println("Before login, title is:==="+ driver.getTitle());
	
	driver.findElement(By.name("username")).sendKeys("naveenk");
	driver.findElement(By.name("password")).sendKeys("test@123");
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("after login, title is:==="+ driver.getTitle());
	
	
	

}}
