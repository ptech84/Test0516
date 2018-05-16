package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sv.base.TestBase;

public class SVOperatorSignOnOPage extends TestBase{
	
	@FindBy(xpath=".//*[@id='TXTOPERATOR']")
	WebElement OperatorTxt;
	
	@FindBy(xpath=".//*[@id='TXTPASSWORD']")
	WebElement PasswordTxt;
	
	@FindBy(xpath=".//*[@id='CMDSIGNON']")
	WebElement SignOnButton;
	
	
	
	public SVOperatorSignOnOPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void LoginToSV(){
		String operatorSignOnPageTitle = driver.getTitle();
		Assert.assertEquals(operatorSignOnPageTitle, "Operator Signon");
		OperatorTxt.sendKeys(prop.getProperty("username"));
		PasswordTxt.sendKeys(prop.getProperty("password"));
		SignOnButton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
}
