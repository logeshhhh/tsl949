package day4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		List<WebElement> listimages=driver.findElements(By.tagName("img"));
		int sz=listimages.size();
		System.out.println("Total images :"+sz);
		
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream("D:\\LTI\\TRAINING\\SELJARS\\data.xlsX"));
		
		XSSFSheet sh=wb.getSheet("Sheet2");
		
		for(int i=0;i<sz;i++)
		{
		
			
			System.out.println(listimages.get(i).getAttribute("src"));
			sh.createRow(i).createCell(0).setCellValue(listimages.get(i).getAttribute("src"));
			
				
		}
		wb.write(new FileOutputStream("D:\\LTI\\TRAINING\\SELJARS\\newdata2.xlsX"));

	}

}
