package codility;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@SuppressWarnings("unused")
public class Solution extends WebDriverTestCase
{

	@Test
	public void test() 
	{
		webDriver.get("https://www.bing.com/");
		assertEquals("Bing",webDriver.getTitle());
	}
		
		@Test
		public void test2() throws Exception 
		{
		webDriver.findElement(By.name("q")).sendKeys("codility");
		webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> ls=webDriver.findElements(By.xpath("//div[@id='b_content']/main/ol/li"));
		assertEquals(true, ls.size()>1);
		assertTrue(ls.size()>1);
		
		
		/*webDriver.get("https://jmeter.apache.org/");
		List<WebElement> ls=webDriver.findElements(By.xpath("//div[@class='nav']/ul[3]/li/ul/li/a"));
		
		assertEquals(10, ls.size());
		/html[1]/body[1]/div[2]/main[1]/ol[1]/li[2]/h2[1]/a[1]
		assertEquals(true, ls.size()>1);
		assertTrue(ls.size()>1);*/
		
		
	}

}
