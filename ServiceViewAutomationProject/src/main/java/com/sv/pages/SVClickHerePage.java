package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.base.TestBase;

public class SVClickHerePage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Click Here to Begin')]")
	WebElement ClickHereToBeginLink;
	
	@FindBy(xpath="//font[contains(text(),'Region SIT Upgrade')]")
	WebElement pageText;
	
	public SVClickHerePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public boolean getPageText(){
		return pageText.isDisplayed();
	}
	
	public SVSignonPage ClickOn_ClickHereToBeginLink(){
		ClickHereToBeginLink.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SVSignonPage();
	}
	

}
