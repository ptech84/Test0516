package com.sv.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sv.base.TestBase;
import com.sv.pages.SVAuthISOSummaryPage;
import com.sv.pages.SVAuthorizationsPage;
import com.sv.pages.SVClickHerePage;
import com.sv.pages.SVCustomerServicePage;
import com.sv.pages.SVHomePage;
import com.sv.pages.SVOperatorSignOnOPage;
import com.sv.pages.SVSignonPage;
import com.sv.utilities.TestUtil;
import com.sv.utilities.Xls_Reader;

public class SVAuthorizationsTest2 extends TestBase{

	public static Xls_Reader reader;
	TestUtil testUtil;
	SVSignonPage svSignonPage;
	SVClickHerePage svClickHerePage;
	SVOperatorSignOnOPage svOperatorSignOnOPage;
	SVHomePage svHomePage;
	SVCustomerServicePage svCustomerServicePage;
	SVAuthorizationsPage svAuthorizationsPage;
	static SVAuthISOSummaryPage svAuthISOSummaryPage;
	
	public SVAuthorizationsTest2(){
		super();
	}
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("************ Initiated Before Suite**********************");
		initialization();
		reader = new Xls_Reader("C:\\Users\\e3009192\\Framework\\ServiceViewAutomationProject\\src\\main\\java\\com\\sv\\testdata\\ServiceViewSheet.xlsx");
		testUtil = new TestUtil();
		svClickHerePage = new SVClickHerePage();
		svOperatorSignOnOPage = new SVOperatorSignOnOPage();
		svSignonPage = new SVSignonPage();
		svHomePage = new SVHomePage();
		svCustomerServicePage = new SVCustomerServicePage();
		svAuthorizationsPage = new SVAuthorizationsPage();
		svAuthISOSummaryPage = new SVAuthISOSummaryPage();
		svClickHerePage.ClickOn_ClickHereToBeginLink();
		svSignonPage.ClickSignOnButton();
		svOperatorSignOnOPage.LoginToSV();
		svHomePage.ClickOn_CustomerServiceButton();
	
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@BeforeMethod
	public void Setup(){
	System.out.println("*******************before method started********************");	
	}
	
		
	@Test(dataProvider="getDataFromExcel")
	public void CaptureTransactionDetails(String acctNo, String time){
	
		svCustomerServicePage.locateAccount(acctNo);
		svCustomerServicePage.NavigateToAuthInquiryPage();
	
			
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
								
				if(!(time.isEmpty())){
				if(actualTime.equals(time)){
					
					 try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
								 
					 
					reader.setCellData("Sheet1", "ResponseCode", i, respCode);
					reader.setCellData("Sheet1", "Amount", i, amount);
					reader.setCellData("Sheet1", "MCC", i, mcc);
					reader.setCellData("Sheet1", "AuthCode", i, AuthCode);
					reader.setCellData("Sheet1", "actualTime", i, actualTime);
					
					transaction.click();
					SVAuthorizationsPage.SummaryButton.click();
					
							
					String declineCd1 = SVAuthISOSummaryPage.declineCode1.getAttribute("value");
					String declineCd2 = SVAuthISOSummaryPage.declineCode2.getAttribute("value");
					String declineCd3 = SVAuthISOSummaryPage.declineCode3.getAttribute("value");
				 
					reader.setCellData("Sheet1", "DeclineCode1", i, declineCd1);
					reader.setCellData("Sheet1", "DeclineCode2", i, declineCd2);
					reader.setCellData("Sheet1", "DeclineCode3", i, declineCd3);
					 
		
					break;
					 
			}
				}
			}
			SVAuthISOSummaryPage.CancelButton.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SVAuthorizationsPage.CloseButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
	}
	
		
	
	@DataProvider
	public Iterator<Object[]> getDataFromExcel(){
		ArrayList<Object[]> dataList = TestUtil.getDataFromXcel();
		return dataList.iterator();
	
		
	}
	
	
		@AfterMethod
	public void tearDown(){
		//driver.quit();
			System.out.println("********initiated tearDown************");
	}
	
	
	

}
