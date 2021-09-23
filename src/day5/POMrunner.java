package day5;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POMrunner 
{
	WebDriver driver;
	LoginPage lp;
	@Test(description="Checking forget link of login page")
	  public void forgetpagetest()  
	  {
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  lp=new LoginPage(driver);
		  lp.clickforget();
		  Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	  }
	
	@Test(dependsOnMethods = "forgetpagetest",description="Checking cancel button")
	  public void cancelbuttontest()  
	  {
		  Forgetpage fp=new Forgetpage(driver);
		  fp.cancel();
		  Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
	  }
	  
	@Test(dependsOnMethods = "cancelbuttontest",description="Checking login button")
	  public void logintest()  
	  {
		  lp.dologin("admin","admin123");
		  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	  }
	 
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
	


