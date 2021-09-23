package day3;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedifAssignment 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.rediff.com/");
		
		driver.switchTo().frame("moneyiframe");
		
		driver.findElement(By.id("query")).sendKeys("Yes Bank LTD");
		Thread.sleep(2000);
		
		driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<String> all=new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(all.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window(all.get(0));
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
