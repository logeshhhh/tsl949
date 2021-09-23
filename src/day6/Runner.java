package day6;

import org.testng.annotations.Test;

import Fm.Base;
import Fm.KeyWords;

public class Runner extends Base 
{
	@Test
	public void f()
	{
		KeyWords key=new KeyWords(driver);
		key.getURL("http://facebook.com");
		key.type("name", "email", "7010933903");
		key.click("name","login");
		key.getSnap("drivers/facebook.png");
		key.getURL("https://blazedemo.com/");
		key.selectFromDropDown("name", "toPort", "Rome");
	}

}
