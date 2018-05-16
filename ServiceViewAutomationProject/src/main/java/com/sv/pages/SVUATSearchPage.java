package com.sv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.base.TestBase;

public class SVUATSearchPage extends TestBase{
	
	@FindBy(xpath="//div[@id='lblTIWMAINMENU2_1']")
	WebElement AuthInquiryMenu;
	
	@FindBy(xpath=".//*[@id='TIWMAINMENU2_1_21t']/div")
	WebElement UATSearchMenu;
	
	@FindBy(xpath="//select[@id='CMBANNUALFEES']")
	public static WebElement AnnualFeesDDL;
	
	public SVUATSearchPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void NavigateToUATSearchPage(){
		
		Actions act = new Actions(driver);
		AuthInquiryMenu.click();
		act.moveToElement(UATSearchMenu).build().perform();
		UATSearchMenu.click();
		
	}
	
	
	

}
