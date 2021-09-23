package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangehrmCSS
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		
		driver.findElement(By.cssSelector("a.panelTrigger")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a[href='/index.php/auth/requestPasswordResetCode']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input#securityAuthentication_userName")).sendKeys("admin");
		Thread.sleep(2000);
		driver.quit();
		

	}

}
