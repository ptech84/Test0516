package com.sv.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class OtherPractice {
	
WebDriver driver;
	
	@Test
	public void TestCase(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
		
	
	driver = new ChromeDriver();

		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://clientlink-uat.fnis.com");
			Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("parent window id:"+ parentWindowId);
		
		
		String childWindowId = it.next();
		System.out.println("Child window id:"+childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		
/*		
		driver.switchTo().frame(0);
		
		WebElement el1 = driver.findElement(By.xpath("//input[@id='datepicker']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','05/06/2018')", el1);*/
		
		

}
}
