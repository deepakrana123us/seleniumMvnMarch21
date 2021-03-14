package com.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.framework.baseClass.TestBaseClass;

public class TestUtils extends TestBaseClass {
	public static String scrshotname ;
	
	public static boolean isTestRunnable (String TestName, ExcelReader excel)
	{
		
		String sheetname = "test_suite" ;
	    int rows = excel.getRowCount(sheetname) ;
		
	    for (int rNum = 2; rNum <= rows; rNum++)
	    {
	      String testcase = excel.getCellData(sheetname, "TCID", rNum) ;
	    	
	      if (testcase.equalsIgnoreCase(TestName))
	      {
	    	  
	    	  String runmode = excel.getCellData(sheetname, "RunMode", rNum) ;
	    	   System.out.println("run mode is " + runmode);
		    	if (runmode.equalsIgnoreCase("Y"))
		    	return true;
		    	else
		        return false;
	      }
	    	
	    }
	    	
	    return false;	
	    	
	}
	
	
	
	
	public static void CaptureScreenShot() throws IOException
	{
		Date d = new Date();
		scrshotname = d.toString().replace(":", "_").replace(" ", "") ;
	    		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		FileUtils.copyFile(src, new File(System.getProperty("User.dir") + "\\target\\surefire-reports\\html\\" + scrshotname +".jpg") )	;
		System.out.println(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + scrshotname +".jpg") ;
	}
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		System.out.println("rows =" + rows) ;
		System.out.println("col =" + cols) ;
		System.out.println("sheet name is " + sheetName) ;
		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
				System.out.println("data printing col = " + data[rowNum - 2][0] );
			}
			System.out.println("data printing row = " + data[rowNum - 2][0] );
		}

		return data;

	}
	
	
	@DataProvider (name ="dp1")
	public Object[][] getData1(Method m) throws Exception
	{
	String SheetName = m.getName() ;	
	int rows = excel.getRowCount(SheetName);
	int cols = excel.getColumnCount(SheetName);
    Object[][] data = new Object[rows-1][cols];
    Hashtable<String, String> table = null;		
    
					System.out.println("rows =" + rows) ;
					System.out.println("col =" + cols) ;
					
			for(int i= 2; i<=rows; i ++)
			{
				table = new Hashtable<String,String>() ;
				for(int j= 0; j<cols; j ++)
				{
					
							//sh.getcellData("addCustomer",j);
					table.put(excel.getCellData(SheetName, j, 1), excel.getCellData(SheetName, j, i)) ;
					data[i-2][0] =  table;
		     	
		     	 
		     	System.out.println("value of i = " + i);
		     	System.out.println("value of j = " + j);
		     	 //System.out.println(data[i-2][j]);
		     	 
				}
					
			}
		
 		return data;
	  }	
	
	
}


