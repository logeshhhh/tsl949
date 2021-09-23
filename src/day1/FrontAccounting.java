package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrontAccounting 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.frontaccounting.eu/");
		
		WebElement u=driver.findElement(By.name("user_name_entry_field"));
		u.clear();
		u.sendKeys("demouser");
		
		WebElement p=driver.findElement(By.name("password"));
		p.clear();
		p.sendKeys("password");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("SubmitUser")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Click here to Login Again.")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
