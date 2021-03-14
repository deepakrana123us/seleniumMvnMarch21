package com.framework.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.framework.baseClass.TestBaseClass;
import com.framework.utilities.TestUtils;


public class AddCustomerTest extends TestBaseClass {

		// private static XSSFRow Row;
 
	 @Test(dataProviderClass = TestUtils.class, dataProvider ="dp")
	public void addCustomerTest(Hashtable <String, String> data)
	{
		  if (!TestUtils.isTestRunnable("addCustomerTest", excel))
			    throw new SkipException ("Skipping the test case" + "addCustomerTest".toUpperCase() );

		  if (!data.get("runmode").equals("Y"))
			   throw new SkipException ("Skipping the test case for add customer as run mode is \"N" );

		 click("add_cust_CSS");
		 type("fname_CSS",data.get("fname"));
		 type("lname_CSS",data.get("lname"));
		 type("postcode_CSS",data.get("postcode"));
		
		 
		   //Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
			//Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
			//alert.accept();
			
		//	Thread.sleep(2000);
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