package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGAssertions {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void invokeBrowser(){
		
		try {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://www.gmail.com/");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
  @Test
  public void testEquality() {
	  
	  Assert.assertEquals(true, isItEqual(10, 12));
	  System.out.println("Amrut Terdal");
  }
  
  public boolean isItEqual(int a, int b){
	  if(a==b){
		  return true;
	  }
	  else{
		  return false;
	  }
  }
  
  @Test
  public void getTitle(){
	  
	  String title = driver.getTitle();
	  Assert.assertEquals(title, "Gmail");
	  System.out.println("Amrut");
  }
  
  @AfterTest
  public void closeBrowser(){
	  driver.quit();
  }
  
}
