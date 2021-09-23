package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeExcel
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream("D:\\LTI\\TRAINING\\SELJARS\\data.xlsX"));
		
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		for(int i=0;i<=3;i++)
		{
			String user=sh.getRow(i).getCell(0).toString();
			System.out.print(user+" ");
			String pass=sh.getRow(i).getCell(1).toString();
			System.out.println(pass);
			System.out.println();
			driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(user);
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pass);
			driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
			
			
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				driver.findElement(By.cssSelector("a.panelTrigger")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
				sh.getRow(i).createCell(2).setCellValue("Login Pass");
			}
			else
			{
				
				sh.getRow(i).createCell(2).setCellValue("Login Fail");
				
				System.out.println("------------------------------------");
			}
			wb.write(new FileOutputStream("D:\\LTI\\TRAINING\\SELJARS\\orangedata.xlsX"));
		
		}
		driver.quit();

	}
}