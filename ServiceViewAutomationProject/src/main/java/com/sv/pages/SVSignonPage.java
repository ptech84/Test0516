package com.sv.pages;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.base.TestBase;

public class SVSignonPage extends TestBase {


	@FindBy(xpath="//input[@id='CMDSIGNON']")
	WebElement SignOnButton;
	
	public SVSignonPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	
	public SVOperatorSignOnOPage ClickSignOnButton(){
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		SignOnButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SVOperatorSignOnOPage();
		
	}




}
