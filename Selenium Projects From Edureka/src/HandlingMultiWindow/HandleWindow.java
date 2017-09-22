package HandlingMultiWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindow {
	
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();   
        driver.get("https://www.naukri.com/");
        
        String parent = driver.getWindowHandle();
        System.out.println("Parent window is "+parent);
        driver.findElement(By.className("blueBtn")).click();
        Set <String> allWindows = driver.getWindowHandles();
        
        int count = allWindows.size();
        
        System.out.println("Total Window"+count);
        
        for(String child:allWindows){
        	if(!parent.equalsIgnoreCase(child)){
        		driver.switchTo().window(child);
        		driver.findElement(By.className("searchJob")).sendKeys("Java developer");
        		Thread.sleep(3000);
        		driver.close();
        	}
        
        	
        	driver.switchTo().window(parent);
        }
        
        

	}

}
