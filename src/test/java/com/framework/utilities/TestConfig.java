package com.framework.utilities;

public class TestConfig{
//DB URL username password - Read only select

	
	public static String server="smtp.gmail.com";
	public static String from = "deepak.rana123us@gmail.com";
	public static String password = "Darwin98*";
	public static String[] to ={"deepak.rana123us@gmail.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="C:\\Users\\way2automation\\Desktop\\screenshot.png";
	public static String attachmentName="error.png";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.cj.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/5thsep2020";
	
	
	
	
	
	
	
	
	
}
