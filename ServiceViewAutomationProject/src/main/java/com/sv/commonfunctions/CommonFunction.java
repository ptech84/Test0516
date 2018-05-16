package com.sv.commonfunctions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sv.base.TestBase;

public class CommonFunction extends TestBase {
	WebDriver driver;
	
	public void SelectDDL(WebElement element, String value){
		
		Select sel = new Select(element);
			sel.selectByVisibleText(value);
		
	}
	

}
