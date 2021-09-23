package day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class FirstScriptNG 
{
  WebDriver driver;
  
  @Test(priority=1,description="verifying title of search page")
  public void googletitle() 
  {
	  driver.get("https://google.com/");
	  String title=driver.getTitle();
	  Assert.assertEquals(title, "Google"); //comparision b/w expected and actual
  }
  
  @Test(priority=2,description="verifying title of search result page")
  public void googlesearch() 
  {
	  driver.findElement(By.name("q")).sendKeys("LTI");
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  
	  String title=driver.getTitle();
	  Assert.assertEquals(title, "LTI - Google Search"); //comparision b/w expected and actual
  }
  
  @BeforeMethod
  public void beforemethod()
  {
	  System.out.println("Before Method");
  }
  
  @AfterMethod
  public void aftermethod(ITestResult res)throws Exception
  {
	  System.out.println("after method");
	  if(res.getStatus()==ITestResult.SUCCESS);
	  {
		  TakesScreenshot t=(TakesScreenshot)driver;
		  File src=t.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src,new File(res.getName()+".png"));
	  }
	  
  }
  
 @BeforeTest        //Pre-condition 
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterTest 		 //Post-condition 
  public void afterTest() throws Exception 
  {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
