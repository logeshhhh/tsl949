package day3;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

public class ActionsexampleforKeyboardControl 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bing.com/");
		
		WebElement search=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		
		Action act=a.keyDown(Keys.SHIFT)
		.sendKeys(search, "lti")
		.doubleClick(search)         
		.contextClick(search)      //right click
		.build();
		
		act.perform();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
