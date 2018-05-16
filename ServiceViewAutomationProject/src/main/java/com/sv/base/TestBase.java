package com.sv.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sv.utilities.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	
	public TestBase(){
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\sv\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public void initialization(){
		String browserName = prop.getProperty("browser");
		switch(browserName){
		
		case "IE": 
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		System.setProperty("webdriver.ie.driver","C:\\Selenium\\BrowserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(cap);
		break;
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "FF":
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
	}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeouts, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
}
