package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.magneticautomation.in/p/dropdown.html");
		Select sc=new Select(driver.findElement(By.name("multi")));
		
		System.out.println("Multi Selection is "+ sc.isMultiple());
		sc.selectByVisibleText("one");
		Thread.sleep(2000);
		sc.selectByIndex(3);
		Thread.sleep(2000);
		sc.selectByValue("4");
		Thread.sleep(2000);
		
		sc.deselectByValue("4");
		Thread.sleep(2000);
		sc.deselectAll();
		//Thread.sleep(2000);
		//driver.quit();

		
	}

}
