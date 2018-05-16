package com.sv.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sv.base.TestBase;
import com.sv.utilities.Xls_Reader;

public class SVAuthISOSummaryPage extends TestBase{
	static Xls_Reader reader;

	@FindBy(xpath="//input[@id='TXTDECLINERSN1CD']")
	public static WebElement declineCode1;
	
	@FindBy(xpath="//input[@id='TXTDECLINERSN2CD']")
	public static WebElement declineCode2;
	
	@FindBy(xpath="//input[@id='TXTDECLINERSN3CD']")
	public static WebElement declineCode3;
	

	@FindBy(xpath="//input[@name='TXTDECLINERSN1']")
	public static WebElement declineCodeDesc1;
	
	@FindBy(xpath="//input[@name='TXTDECLINERSN2']")
	public static WebElement declineCodeDesc2;
	
	@FindBy(xpath="//input[@name='TXTDECLINERSN3']")
	public static WebElement declineCodeDesc3;

	
	@FindBy(xpath="//input[@id='CMDCANCEL']")
	public static WebElement CancelButton;
	
	public SVAuthISOSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public ArrayList<Object[]> getDataFromAuthISOSummaryFields(){
		
		ArrayList<Object[]> codes = new ArrayList<Object[]>();
		String declineCd1 = declineCode1.getAttribute("value");
		String declineCd2 = declineCode2.getAttribute("value");
		String declineCd3 = declineCode3.getAttribute("value");
	 
	 String[] list = {declineCd1, declineCd2, declineCd3};
	 codes.add(list);
	return codes;

	 
		
	}
	
	

}
