package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActivityTask 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.name("query")).sendKeys("Yes Bank LTD");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();


	}

}
