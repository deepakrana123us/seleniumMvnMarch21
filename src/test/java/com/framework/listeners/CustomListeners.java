package com.framework.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.rmi.UnknownHostException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.framework.baseClass.TestBaseClass;
import com.framework.utilities.MonitoringMail;
import com.framework.utilities.TestConfig;
import com.framework.utilities.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBaseClass implements ITestListener,ISuiteListener {
	public static String scrshotname;

	public void onTestStart(ITestResult result) {
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		TestBaseClass.test.log(LogStatus.PASS, result.getName().toUpperCase() + " Pass");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			TestUtils.CaptureScreenShot();
			TestBaseClass.test.log(LogStatus.FAIL,
					result.getName().toUpperCase() + " failed with exception custom" + result.getThrowable());
			// TestBaseClass.test.log (LogStatus.FAIL,TestUtils.CaptureScreenShot() );

			rep.endTest(test);
			rep.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<br>");
		Reporter.log("Capturing Screenshot");
		Reporter.log("<a target = \"_blank\" href = " + TestUtils.scrshotname + "> <image src = "
				+ TestUtils.scrshotname + " </Image>\" </a>");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
	  test = rep.startTest(context.getName().toUpperCase());
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		MonitoringMail mail = new MonitoringMail();
		String Messagebody = "" ;
		try {
			Messagebody = "https://" + InetAddress.getLocalHost().getHostAddress() + ":8080/jobs/MyMavenProject/builds/18/htmlreports/verifytestngreports/" ;
				
		}  catch (java.net.UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, Messagebody,TestConfig.attachmentName, TestConfig.attachmentPath);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
