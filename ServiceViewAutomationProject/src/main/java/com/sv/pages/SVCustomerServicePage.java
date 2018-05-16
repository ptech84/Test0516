package com.sv.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.base.TestBase;

public class SVCustomerServicePage extends TestBase {
	
	@FindBy(xpath="//input[@name='TXTACCTNBR']") 
	WebElement acctNoText;
	
	@FindBy(xpath="//input[@name='CMDLOCATE']")
	WebElement locateButton;

	@FindBy(xpath="//div[@id='TIWMAINMENU2_1_5_1div']/table/tbody/tr/td[2]/div[contains(text(),'Inquiry')]")
	WebElement AuthorizationInquiryMenu;
	
	@FindBy(xpath="//div[@id='lblTIWMAINMENU2_1']")
	WebElement AuthInquiryMenu;
	
	@FindBy(xpath=".//*[@id='TIWMAINMENU2_1_5t']")
	WebElement AuthInquiryMenu_Authorizations;
	
	@FindBy(xpath=".//*[@id='TIWMAINMENU2_1_21t']/div")
	WebElement UATSearchMenu;
	
	
	public SVCustomerServicePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void locateAccount(String accountno){
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		acctNoText.clear();
		acctNoText.sendKeys(accountno);
		locateButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SVAuthorizationsPage NavigateToAuthInquiryPage(){
		
		Actions act = new Actions(driver);
		AuthInquiryMenu.click();
		act.moveToElement(AuthInquiryMenu_Authorizations).build().perform();
		//act.click(AuthorizationInquiryMenu);
		AuthorizationInquiryMenu.click();		
		return new SVAuthorizationsPage();
	}

}
