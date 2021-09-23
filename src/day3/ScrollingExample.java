package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingExample 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		WebElement E=driver.findElement(By.linkText("@diegofmolina"));
		
		JavascriptExecutor j =(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView();", E);
		
		Thread.sleep(2000);
		
		j.executeScript("window.scrollBy(0,-300)"); //scroll up
		Thread.sleep(2000);
		
		j.executeScript("window.scrollBy(0,600)");  //scroll down
		Thread.sleep(2000);
		
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");  //scroll down till end of the page
		Thread.sleep(2000);
		
		j.executeScript("window.scrollBy(0,-document.body.scrollHeight)");  //scroll up till end of the page
		Thread.sleep(2000);
		
		driver.quit();

	}

}
