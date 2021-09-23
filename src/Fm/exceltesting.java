package Fm;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exceltesting 
{

	WebDriver driver;
	
	  @Test(dataProvider = "dp")
	  public void logintest(String user, String pass) throws Exception 
	  {
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(user);
		  driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pass);
		  driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Logout")).click();
	  }
	  
	 
	  @BeforeTest        
	  public void beforeTest() 
	  {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		  
	  }

	  
	  @AfterTest 		 
	  public void afterTest() throws Exception 
	  {
		  Thread.sleep(2000);
		  driver.quit();
	  }
	  
	 
	  @DataProvider
	  public Object[][] dp() throws Exception
	  {
		Excel sh= new Excel("D:\\LTI\\TRAINING\\SELJARS\\data.xlsx");
		
		Object data[][]=new Object[sh.getRowNum("sheet1")][sh.getColNum("sheet1")];
		
		for(int i=0;i<data.length;i++)
		{
			data[i][0]=sh.getData("sheet1", i, 0);
			data[i][1]=sh.getData("sheet1", i, 1);
		}
		return data;
	  }
	}