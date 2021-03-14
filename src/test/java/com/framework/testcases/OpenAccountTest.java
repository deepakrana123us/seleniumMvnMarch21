package com.framework.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.framework.baseClass.TestBaseClass;
import com.framework.utilities.TestUtils;


public class OpenAccountTest extends TestBaseClass {

		// private static XSSFRow Row;

	 
	 @Test(dataProviderClass = TestUtils.class, dataProvider ="dp")
	public void openAccountTest(Hashtable <String, String> data)
	{
		  if (!TestUtils.isTestRunnable("openAccountTest", excel))
			    throw new SkipException ("Skipping the test case" + "openAccountTest".toUpperCase() );
		  if (!data.get("runmode").equals("Y"))
			   throw new SkipException ("Skipping the test case for open customer as run mode is \"N" );

		click("open_acct_CSS");
		select("customer_CSS",data.get("customer"));
		select("currency_CSS",data.get("currency"));
		click("process_CSS");
		 
	//driver.findElement((By.cssSelector(OR.getProperty("add_cust")))).click();
	// driver.findElement((By.cssSelector(OR.getProperty("fname")))).sendKeys(fname);
	// driver.findElement((By.cssSelector(OR.getProperty("lname")))).sendKeys(lname);
	 //driver.findElement((By.cssSelector(OR.getProperty("postcode")))).sendKeys(postcode);
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 driver.findElement((By.cssSelector(OR.getProperty("submitCust_CSS")))).click();
		
	}
	
	}	