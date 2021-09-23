package Fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base 
{ 
	 public WebDriver driver;
	 @BeforeTest        
	  public void beforeTest() 
	  {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		  
	  }

	  
	  @AfterTest 		 
	  public void afterTest() throws Exception 
	  {
		  Thread.sleep(2000);
		  driver.quit();
	  }
}
