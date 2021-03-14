package com.framework.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperty {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Properties config = new Properties();
		Properties OR = new Properties();
		//System.out.println(System.getProperty("user.dir"));		
		FileInputStream fis = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\prop\\Config.properties");
		try {
			config.load(fis);
			System.out.println(config.getProperty("browser"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fis = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\prop\\OR.properties");
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
