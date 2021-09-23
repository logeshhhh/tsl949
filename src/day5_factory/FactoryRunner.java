package day5_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import day5.Forgetpage;



public class FactoryRunner 
{
	WebDriver driver;
	Loginpage lp;
	
	@Test
	public void forgetlinktest()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		lp= PageFactory.initElements(driver,Loginpage.class);
		lp.clickforget();
		Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"));
	}
	
	@Test(dependsOnMethods = "forgetlinktest")
	public void cancelbuttontest()  
	  {
		  Forgetpage fp= PageFactory.initElements(driver, Forgetpage.class);
		  fp.cancel();
		  Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
	  }
	
	@Test(dependsOnMethods = "cancelbuttontest")
	  public void logintest()  
	  {
		  WebDriverWait wt =  new WebDriverWait(driver, 20);
		 
		  lp.dologin("admin","admin123");
		  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		  
		  driver.findElement(By.id("welcome")).click();
		  
		  wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		  driver.findElement(By.linkText("Logout")).click();
	  }
	
	//implicit wait ----> driver.manage().timeouts().implicitlywait(20.Timeunit.SECONDS);
	//explicit wait ----> WebDriverWait wt =  new WebDriverWait(driver, 20);
	
	@BeforeTest        
	 @Parameters("browser")
	  public void beforeTest(String browser) 
	  {
		 if(browser.equals("chrome"))
		 {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		 }
		 else if(browser.equals("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			  driver = new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("Wrong browser");
		 }
		  
	  }

	  
	  @AfterTest 		 
	  public void afterTest() throws Exception 
	  {
		  Thread.sleep(2000);
		  driver.quit();
	  }

}
