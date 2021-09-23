package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Forgetpage 
{
	WebDriver driver;
	public Forgetpage(WebDriver driver)
	{
		this.driver=driver;
	}
	By e_username=By.name("securityAuthentication[userName]");
	By e_reset=By.id("btnSearchValues");
	By e_cancel=By.id("btnCancel");

	public void reset(String username)
	{
		driver.findElement(e_username).sendKeys(username);
		driver.findElement(e_reset).click();
	}

	public void cancel()
	{
		driver.findElement(e_cancel).click();
	}



}