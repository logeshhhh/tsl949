package day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Easemytrip 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com/");
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("spn3")).click();
		driver.findElement(By.cssSelector("input[onclick='SearchFlightWithArmy();']")).click();
		
		
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		
	}

}
