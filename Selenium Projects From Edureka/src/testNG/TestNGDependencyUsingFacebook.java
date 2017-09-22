package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGDependencyUsingFacebook {

	WebDriver driver;

	@Test
	public void k() {
	}

	@Test
	public void e() {
	}

	@Test
	public void m() {
	}

	@Test(priority = 0)
	public void n() {
		System.out.println("This is priority");
	}

	@Test
	void openBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = {"openBrowser"})
	public void loginToFacebook() {
		driver.get("http://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("amrut.t2011@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("u_0_r")).click();
		

	}

}
