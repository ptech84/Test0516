package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.base.TestBase;

public class SVHomePage extends TestBase {
	
	@FindBy(xpath="//input[@id='CMDCUSTSRV']")
	WebElement CustomerServiceButton;
	

	public SVHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
		
	public SVCustomerServicePage ClickOn_CustomerServiceButton(){
		CustomerServiceButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SVCustomerServicePage();
	}

}
