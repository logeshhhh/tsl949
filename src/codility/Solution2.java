package codility;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Solution2 extends WebDriverTestCase
{
	WebElement ls;
	@Test
	public void test() 
	{
		webDriver.get("https://opensource-demo.orangehrmlive.com/");
		assertEquals("OrangeHRM",webDriver.getTitle());
	}


	@Test
	public void test1() throws Exception 
	{
		
		webDriver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);
		
		ls=webDriver.findElement(By.id("spanMessage"));
		assertEquals("Username cannot be empty",ls.getText());
	}
	
	@Test
	public void test2() throws Exception 
	{
		
		webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
		webDriver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);
		
		ls=webDriver.findElement(By.id("spanMessage"));
		assertEquals("Password cannot be empty",ls.getText());
		webDriver.findElement(By.id("txtUsername")).clear();
	}
	
	@Test
	public void test3() throws Exception 
	{
		
		webDriver.findElement(By.id("txtUsername")).sendKeys("Adminnn");
		webDriver.findElement(By.id("txtPassword")).sendKeys("admin12345");
		webDriver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);
		
		ls=webDriver.findElement(By.id("spanMessage"));
		assertEquals("Invalid credentials",ls.getText());
		webDriver.findElement(By.id("txtUsername")).clear();
		webDriver.findElement(By.id("txtPassword")).clear();
	}
	

}
