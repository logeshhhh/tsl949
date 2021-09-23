package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://blazedemo.com/");
		WebElement f=driver.findElement(By.name("fromPort"));
		Select s1=new Select(f);
		s1.selectByVisibleText("Boston");
		Thread.sleep(3000);
		
		WebElement f1=driver.findElement(By.name("toPort"));
		Select s2=new Select(f1);
		s2.selectByValue("London");
		Thread.sleep(3000);
		
		s2.selectByIndex(4);
		Thread.sleep(3000);
		
		/*driver.findElement(By.value("btn btn-primary")).click();
		Thread.sleep(3000);*/
		
		driver.quit();
	}

}
