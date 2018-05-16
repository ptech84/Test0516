package com.sv.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.base.TestBase;
import com.sv.utilities.TestUtil;
import com.sv.utilities.Xls_Reader;

public class SVAuthorizationsPage extends TestBase {
	
	@FindBy(xpath="//input[@id='TXTTOTAVAILABLE']") 
	WebElement availCreditText;
	
	@FindBy(xpath="//input[@id='TXTTOTCASHAVAILABLE']")
	WebElement availCashText;

	@FindBy(xpath="//div[@id='TIWMAINMENU2_1_5_1div']/table/tbody/tr/td[2]/div[contains(text(),'Inquiry')]")
	WebElement AuthorizationInquiryMenu;
	
	@FindBy(xpath="//input[@id='CMDSUMMARY']")
	public static WebElement SummaryButton;
	
	@FindBy(xpath="//input[@id='CMDMORE']")
	WebElement MoreButton;
	
	@FindBy(xpath="//input[@id='CMDCLOSE']")
	public static WebElement CloseButton;
	
	
	
	public SVAuthorizationsPage(){
		PageFactory.initElements(driver, this);
	}
	
		
	public ArrayList<Object[]> ClickOnAuthTimeTransaction(String time){
		


		ArrayList<Object[]> codes = new ArrayList<Object[]>();
		
		String timeBeforeXpath = "//div[@id='GRDAUTHLISTdiv1']/table[@id='GRDAUTHLIST_']/tbody/tr[";
	    String timeAfterXpath = "]/td[5]";
	    
	    String authCodeBeforeXpath = "//div[@id='GRDAUTHLISTdiv1']/table[@id='GRDAUTHLIST_']/tbody/tr[";
	    String authCodeafterXpath = "]/td[3]";
	    
	    String respCodeBeforeXpath = "//div[@id='GRDAUTHLISTdiv1']/table[@id='GRDAUTHLIST_']/tbody/tr[";
	    String respCodeafterXpath = "]/td[6]";
	    
	    
	    String amtCodeBeforeXpath = "//div[@id='GRDAUTHLISTdiv1']/table[@id='GRDAUTHLIST_']/tbody/tr[";
	    String amtCodeafterXpath = "]/td[15]";
	    
	    String mccCodeBeforeXpath = "//div[@id='GRDAUTHLISTdiv1']/table[@id='GRDAUTHLIST_']/tbody/tr[";
	    String mccCodeafterXpath = "]/td[16]";
	    
	    
	List<WebElement> list = driver.findElements(By.xpath("//div[@id='GRDAUTHLISTdiv1']/table/tbody/tr"));
	   int rowCount= list.size();
	  
		for(int i=1; i<=rowCount;i++){
			 String AuthCode = driver.findElement(By.xpath(authCodeBeforeXpath + i + authCodeafterXpath)).getText();
			 String respCode = driver.findElement(By.xpath(respCodeBeforeXpath + i + respCodeafterXpath)).getText();
			 String amount = driver.findElement(By.xpath(amtCodeBeforeXpath + i + amtCodeafterXpath)).getText();
			 String mcc = driver.findElement(By.xpath(mccCodeBeforeXpath + i + mccCodeafterXpath)).getText();
			String actualTime = driver.findElement(By.xpath(timeBeforeXpath + i + timeAfterXpath)).getText();
			WebElement transaction = driver.findElement(By.xpath(timeBeforeXpath + i + timeAfterXpath));
			
			 String[] codesList = {respCode, amount, mcc,AuthCode, actualTime};
			 codes.add(codesList);
				
			if(!(time.isEmpty())){
			if(actualTime.equals(time)){
				
				transaction.click();
				SummaryButton.click();
				
				break;
			} 
			
			} else {
				System.out.println("time does not exist");
				break;
			}
			
		}
		return codes;
	
	}
	
}
