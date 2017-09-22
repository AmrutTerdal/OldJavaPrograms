package com.edureka.Selenium.Driver.Besics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseElementLocatorTechnique {
	
	WebDriver driver;
	
	public void invokeBrowser( String url){
		
		//System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		try {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void elementLocatorUsingAmazon(){
		
		try {
			invokeBrowser("http://www.amazon.in/");
			driver.findElement(By.linkText("Your Amazon.in")).click();
			driver.navigate().back();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptops");
			driver.findElement(By.className("nav-input")).click();
			driver.navigate().back();
			driver.findElement(By.partialLinkText("Customer")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeBrowser(){
		driver.close();
	}
	
	public void elementLocatorUsingFacebook(){
		
		invokeBrowser("https://www.facebook.com/");
		driver.findElement(By.name("firstname")).sendKeys("Amrut");
		driver.findElement(By.name("lastname")).sendKeys("Terdal");
		driver.findElement(By.id("u_0_7")).sendKeys("amrut.t2011@gmail.com");
		
		
		
		
		
	}
	
	public void elementLocatorUsingPaytm(){
		
		invokeBrowser("https://www.paytm.com/");
		driver.findElement(By.xpath("//div[@data-reactid='46']")).click();
	}
	
	public void elementLocatorUsingYathra(){
		
		invokeBrowser("https://www.yatra.com/");
		driver.findElement(By.id("BE_flight_depart_date")).click();
		driver.findElement(By.xpath("//div [id='PegasusCal-0-month-7-2017']/tbody/tr[6]/td/a/span")).click();
		
	}
	

	public static void main(String[] args) {
	

		UseElementLocatorTechnique myObj = new UseElementLocatorTechnique();
		myObj.elementLocatorUsingAmazon();
		//myObj.elementLocatorUsingFacebook();
		//myObj.elementLocatorUsingPaytm();
		// myObj.elementLocatorUsingYathra();
	}

}
