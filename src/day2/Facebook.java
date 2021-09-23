package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// waits fort visibility of object and should be declared only once
		
		driver.get("http://en-gb.facebook.com/");
		
		driver.findElement(By.linkText("Create New Account")).click();
		
		driver.findElement(By.cssSelector("input[value='2']")).click();
		
		List<WebElement> l=driver.findElements(By.name("sex"));
		l.get(2).click();
		
		for(int i=0;i<l.size();i++)
		{
			Thread.sleep(2000);
			l.get(i).click();
		}
	}

}
