package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///D:/LTI/TRAINING/SELENIUM%20TESTING/iframe.html");
		
		driver.switchTo().frame("front");
		driver.findElement(By.cssSelector("input[type='text']")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).clear();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		driver.switchTo().frame(1);
		driver.findElement(By.name("q")).sendKeys("monza");
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		WebElement third=driver.findElement(By.className("dummy"));
		driver.switchTo().frame(third);
		driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
		Thread.sleep(2000);
		
		driver.quit();
		

	}

}
