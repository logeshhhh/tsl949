package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By e_username=By.name("txtUsername");
	By e_password=By.id("txtPassword");
	By e_login=By.id("btnLogin");
	By e_forget=By.linkText("Forgot your password?");
	
	public void setusername(String user)
	{
		driver.findElement(e_username).sendKeys(user);
	}

	public void setpassword(String pass)
	{
		driver.findElement(e_password).sendKeys(pass);
	}
	
	public void clicklogin()
	{
		driver.findElement(e_login).click();
	}
	public void dologin(String user,String pass)
	{
		setusername(user);
		setpassword(pass);
		clicklogin();
	}
	public void clickforget()
	{
		driver.findElement(e_forget).click();
	}
	
}
