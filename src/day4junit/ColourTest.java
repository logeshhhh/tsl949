package day4junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class ColourTest 
{

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
		driver.get("https://blazedemo.com/");
		WebElement e=driver.findElement(By.cssSelector("input[value='Find Flights']"));
		
		String color=e.getCssValue("background-color");
		System.out.println(color);
		
		String colorhex=Color.fromString(color).asHex();
		System.out.println(colorhex);
		assertEquals("#006dcc",colorhex);
	
	}

}
