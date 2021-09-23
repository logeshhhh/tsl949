package day4junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

@SuppressWarnings("unused")
public class FirstJunit {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		Thread.sleep(2000);
	    driver.quit();
	}

	

	@Test
	public void test() 
	{
		driver.get("https://www.formula1.com/");
		String title=driver.getTitle();
	    assertEquals("F1 - The Official Home of Formula 1® Racing",title); //comparision b/w actual and expected
	}

}
