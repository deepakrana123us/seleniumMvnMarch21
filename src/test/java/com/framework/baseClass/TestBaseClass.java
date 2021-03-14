package com.framework.baseClass;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.framework.utilities.ExcelReader;
import com.framework.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis ;
	public static Logger Log = Logger.getLogger("deepak");
	public static ExcelReader excel = new ExcelReader((System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\testdata.xlsx"));
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	@BeforeSuite
	public static void setUP() throws IOException
	{
		if (driver==null)
		{
			try {
				PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\prop\\log4j.properties");
				fis = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\prop\\Config.properties");
				config.load(fis);
			//	Log.debug("ss");
				Log.debug("Config file loaded" );
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\prop\\OR.properties");
				OR.load(fis);
				Log.debug("OR file loaded" );
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if ((!(System.getenv("browser")==null) &&  !(System.getenv("browser")=="")))
			{  browser = System.getenv("browser") ; }
			else
			{	browser = config.getProperty("browser") ; }
			
			config.setProperty("browser", browser) ;
			
			
			if (config.getProperty("browser").equals("firefox"))
            {
            	driver = new FirefoxDriver();
            	            	
	        }
			
			if (config.getProperty("browser").equals("Chrome"))
            {
            	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				Log.debug("chrome driver loaded");
				
		 	            	
	        }

			driver.get(config.getProperty(("testsiteurl")));
			Log.debug("site loaded");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		if (driver!=null)
		{
		// driver.quit();
		 Log.debug("site exitting");
						
		}
		
	}
	
	public void click (String locator)
	{
		if (locator.endsWith("_CSS"))
				{		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
				}
				else if (locator.endsWith("_XPATH"))
				{
					driver.findElement(By.xpath(OR.getProperty(locator))).click();
				}
				
				test.log(LogStatus.INFO, "Clicking on " + locator);
		
	}
	
	public void type (String locator, String data)
	{
		if (locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(data);		
		}
		else if (locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(data);		
				
		}
     test.log(LogStatus.INFO, "Sending" + data);	
	}
	static WebElement dropdown;
	public void select (String locator,  String data)
	{
		if (locator.endsWith("_CSS"))
		{
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));		
		}
		else if (locator.endsWith("_XPATH"))
		{
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator))) ;		
				
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(data);
		
     test.log(LogStatus.INFO, "selecting from drop down " + data);	
	}
	
	
	public boolean isElementPresent(By by)
	{
		
		try {
			driver.findElement(by);
			return true;
			
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	
}
