package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Blazedemo 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://blazedemo.com/");
		WebElement f=driver.findElement(By.name("fromPort"));
		Select s1=new Select(f);
		s1.selectByVisibleText("Boston");
		Thread.sleep(1500);
		
		WebElement f1=driver.findElement(By.name("toPort"));
		Select s2=new Select(f1);
		s2.selectByValue("London");
		Thread.sleep(1500);
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		List<WebElement> l=driver.findElements(By.cssSelector("input[value='Choose This Flight'])"));
		l.get(2).click();
		
		//driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#inputName")).sendKeys("Logesh");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#address")).sendKeys("7th Street");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#city")).sendKeys("Chennai");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#state")).sendKeys("Tamilnadu");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#zipCode")).sendKeys("630001");
		Thread.sleep(1000);
		
		WebElement f2=driver.findElement(By.name("cardType"));
		Select s3=new Select(f2);
		s3.selectByIndex(1);
		Thread.sleep(1500);
		
		driver.findElement(By.cssSelector("input#creditCardNumber")).sendKeys("1234 5678 9000");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#creditCardMonth")).clear();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#creditCardMonth")).sendKeys("10");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#creditCardYear")).clear();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#creditCardYear")).sendKeys("2021");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input#nameOnCard")).sendKeys("Logesh");
		Thread.sleep(1000);
		
		WebElement e=driver.findElement(By.cssSelector("input[type='checkbox']"));
		boolean x=e.isDisplayed();
		boolean y=e.isEnabled();
		boolean z=e.isSelected();
		
		System.out.println("Displaying on screen "+x);
		System.out.println("Enabled for operations "+y);
		System.out.println("By default Selected  "+z);
		
		e.click();
		Thread.sleep(1500);
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);
		
		driver.quit();
		

	}

}
