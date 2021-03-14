package com.framework.baseClass;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.framework.utilities.TestUtils;

public class LoginTest extends TestBaseClass {

	@Test
	public void loginTest() throws InterruptedException
	{
		 if (!TestUtils.isTestRunnable("loginTest", excel))
			    throw new SkipException ("Skipping the test case" + "loginAsBankManager".toUpperCase() );

		//System.setProperty("org.uncommons.reportng.escape-output", "false") ;
		//driver.findElement(By.cssSelector(OR.getProperty("login_CSS"))).click();
		click("login_CSS");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("login_CSS"))),"Element is present" ) ;
	    Reporter.log("Bank manager login");
	  //  Reporter.log("<br>");
	   // Reporter.log("<a target = \"_blank\" href = \"C:\\Users\\USER\\Desktop\\Workspace\\paytmFeesPayment.png\"> <image src = \"C:\\Users\\USER\\Desktop\\Workspace\\paytmFeesPayment.png\" </Image>\" </a>") ;
		Thread.sleep(3000);
		
	}
	

}
