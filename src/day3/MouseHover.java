package day3;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class MouseHover 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		
		Actions a=new Actions(driver);
		WebElement perf=driver.findElement(By.linkText("Performance"));
		a.moveToElement(perf).perform();
		a.click(driver.findElement(By.linkText("My Trackers"))).perform();
		
		TakesScreenshot ts=(TakesScreenshot)driver;    //typecasting converstion of driver to take screenshot
		File src=ts.getScreenshotAs(OutputType.FILE);  
		FileHandler.copy(src, new File("orange.png"));  //copying from buffer memory

	}

}
