package com.sv.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class CommonTest {
	@FindBy(xpath="//a[@id='pnnext']/span[2]")
	public static WebElement nextLink;
	WebDriver driver;
	
	@Test
	public void TestCase(){
		
/*		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		 capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);*/

		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\BrowserDrivers\\geckodriver.exe");
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");*/
		/* driver = new InternetExplorerDriver(capabilities);*/
	
	driver = new FirefoxDriver();


		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.findElement(By.id("lst-ib")).sendKeys("Java");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//WebElement prevLink = driver.findElement(By.xpath("//a[@id='pnprev']/span[2]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",nextLink);
			
		while(nextLink.isDisplayed()){
		
			nextLink.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);",nextLink);
		} 
		
	
	}}

