package day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
public class FirstScript 
{

	public static void main(String[] args) throws Exception 
	{
		
		System.out.println("Hello !");
		System.out.println("Choose Browser");
		System.out.println(" ");
		System.out.println("press 1 for Chrome");
		System.out.println("press 2 for Firefox");
		
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		WebDriver driver = null;
		switch (c) 
		{
		
		case 1:
		
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		
		case 2:
		
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		
		default:
			System.out.println("Wrong Choice Entered");
		
		}
		if(driver != null)
		{
			driver.get("https://www.selenium.dev/");
			String title = driver.getTitle();
			System.out.println("You are on "+title+" page !");
			
			driver.findElement(By.linkText("Projects")).click();
			String title1 = driver.getTitle();
			System.out.println("You are on "+title1+" page !");
			
			Thread.sleep(5000);
			driver.quit();
			
		}
	}

}

