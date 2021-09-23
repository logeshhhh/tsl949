package day4;

import org.testng.annotations.Test;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataDrivenTesting 
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
	XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream("D:\\LTI\\TRAINING\\SELJARS\\data.xlsX"));  
	XSSFSheet sh=wb.getSheet("Sheet1");
	
	Object data[][]=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
	
	/*Object data[][]=new Object[4][2];
    data[0][0]="admin";
    data[0][1]="admin123";
    data[1][0]="user";
    data[1][1]="user123";
    data[2][0]="hr";
    data[2][1]="hr123";
    data[3][0]="demo";
    data[3][1]="demo123";*/
	
	
	for(int i=0;i<data.length;i++)
	{
		data[i][0]=sh.getRow(i).getCell(0).toString();
		data[i][1]=sh.getRow(i).getCell(1).toString();
	}
	return data;
  }
}
