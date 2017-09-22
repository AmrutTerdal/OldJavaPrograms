package com.edureka.Selenium.Driver.Besics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTestOnEbay {

	WebDriver driver;
	Screen myScreen;

	public void invokeBrowser(String url) {

		try {
			System.setProperty("webdriver.chrome.driver",
					"F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://www.ebay.in/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	public void searchOnEbay(){
		
		try {
			Pattern ebayDeals = new Pattern("‪C:\\Users\\amrut\\Desktop\\ringtones\\Deals.PNG");
			Pattern ebayHomeDeals = new Pattern("C:\\Users\\amrut\\Desktop\\ringtones\\lap.PNG");
			
			myScreen.wait(ebayDeals, 10);
			myScreen.click(ebayDeals);
			myScreen.wait(ebayHomeDeals, 10);
			myScreen.click(ebayHomeDeals);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
