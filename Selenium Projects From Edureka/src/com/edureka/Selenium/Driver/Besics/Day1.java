package com.edureka.Selenium.Driver.Besics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {
	
	WebDriver driver;
	
	JavascriptExecutor jse;
	
	public void invokeBrowser(){
		
		try {
			System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://www.edureka.co");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void searchCourse(){
		
		
	}
	

	public static void main(String[] args) {
		
		
		Day1 myObj = new Day1();
		myObj.invokeBrowser();
		
		
		
		

	}

}
