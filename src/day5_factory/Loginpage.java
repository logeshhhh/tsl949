package day5_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage 
{
	@FindBy(name="txtUsername")WebElement e_username;
	@FindBy(id="txtPassword")WebElement e_password;
	@FindBy(id="btnLogin")WebElement e_login;
	@FindBy(linkText="Forgot your password?")WebElement e_forget;

	public void setusername(String user)
	{
		e_username.sendKeys(user);
	}

	public void setpassword(String pass)
	{
		e_password.sendKeys(pass);
	}
	
	public void clicklogin()
	{
		e_login.click();
	}
	public void dologin(String user,String pass)
	{
		setusername(user);
		setpassword(pass);
		clicklogin();
	}
	public void clickforget()
	{
		e_forget.click();
	}
	
}
