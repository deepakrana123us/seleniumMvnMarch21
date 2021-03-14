package com.framework.utilities;

import java.util.Date;

public class datetime {

 public static void main(String args[])
 {
 
    Date d = new Date();
    String screenshotname = d.toString().replace(":", "_").replace(" ", "") ;
    System.out.println(screenshotname);
    
    
    
}
}