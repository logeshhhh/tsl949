package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youtube
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.youtube.com/");
		driver.findElement(By.id("search")).sendKeys("MrBeast");
		Thread.sleep(2500);
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
