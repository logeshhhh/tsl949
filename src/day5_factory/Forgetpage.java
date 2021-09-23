package day5_factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Forgetpage 
{
	@FindBy(name="securityAuthentication[userName]")WebElement e_username;
	@FindBy(id="btnSearchValues")WebElement e_reset;
	@FindBy(id="btnCancel")WebElement e_cancel;


	public void reset(String username)
	{
		e_username.sendKeys(username);
		e_reset.click();
	}
	
	public void cancel()
	{
		e_cancel.click();
	}

}