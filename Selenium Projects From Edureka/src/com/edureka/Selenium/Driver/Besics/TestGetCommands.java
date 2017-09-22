package com.edureka.Selenium.Driver.Besics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGetCommands {

	WebDriver driver;
	
	public void invokeBrowser(){
		
		try {
			System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			getCommands();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getCommands(){
		
		try {
			driver.get("http://www.amazon.in/");
			String titleOfPage = driver.getTitle();
			System.out.println("The Title of Page is"+titleOfPage);
			driver.findElement(By.linkText("Sell")).click();
			String currentUrl = driver.getCurrentUrl();
			System.out.println("The Current URL is "+currentUrl);
			driver.findElement(By.linkText("Your Amazon.in")).click();;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		 
		TestGetCommands test = new TestGetCommands();
		test.invokeBrowser();

	}

}
