package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindow 
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		String pid=driver.getWindowHandle();
		System.out.println("Parent window id "+pid);
		
		Set<String>all=driver.getWindowHandles();
		
		/*for(String id:all) 
		{
			System.out.println(id);
			
			}
			
		}*/
		List<String> all2=new ArrayList<>(all);
		driver.switchTo().window(all2.get(2));
		System.out.println("Second window title is "+driver.getTitle());
		
		for(int i=0;i<all2.size();i++)
		{
			String id=all2.get(i);
			if(!id.equals(pid))
			{
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver.close();
			}
			
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
