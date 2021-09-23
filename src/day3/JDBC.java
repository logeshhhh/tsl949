package day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBC 
{

	public static void main(String[] args) throws Exception
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","hr","hr");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from tsl949");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		while(rs.next()==true)
		{		
			
			String a=rs.getString("user_name");
			String b=rs.getString("password");
			
			System.out.println(a+ " "+b);
			
			driver.findElement(By.id("txtUsername")).sendKeys(a);
			driver.findElement(By.name("txtPassword")).sendKeys(b);
			driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
			
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				driver.findElement(By.cssSelector("a.panelTrigger")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
				System.out.println("Login Pass");
				
			}
			else {
				System.out.println("Login Fail");
				System.out.println("-----------------------------");
				
			}
		
		}
		rs.close();
		con.close();
		driver.quit();

	}



	}