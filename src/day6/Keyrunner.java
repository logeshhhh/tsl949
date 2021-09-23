package day6;

import org.testng.annotations.Test;

import Fm.Base;
import Fm.Excel;
import Fm.KeyWords;

import org.testng.annotations.DataProvider;

public class Keyrunner extends Base
{
  @Test(dataProvider = "dp")
  public void excelKeyrunner(String exKey, String locatorType, String locatorValue,String data)
  {
	  KeyWords key=new KeyWords(driver); 
	  if (exKey.equals("getURL"))
		  key.getURL(data);
	  else if (exKey.equals("click"))
		  key.click(locatorType, locatorValue);
	  else if (exKey.equals("type"))
		  key.type(locatorType, locatorValue, data);
	  else if (exKey.equals("selectFromDropDown"))
		  key.selectFromDropDown(locatorType, locatorValue, data);
	  else if (exKey.equals("getSnap"))
		  key.getSnap(data);
	  else
		  System.out.println("Invalid key");
  
  }

  @DataProvider
  public Object[][] dp()
  {
	  Excel ex=new Excel("D:\\LTI\\TRAINING\\SELJARS\\blazedemo.xlsx");
	  Object data[][]=new Object[ex.getRowNum("Sheet5")-1][ex.getColNum("Sheet5")];
	  
	  for(int i=0;i<data.length;i++) 
	  {
		  data[i][0]=ex.getData("Sheet5", i+1, 0);
		  data[i][1]=ex.getData("Sheet5", i+1, 1);
		  data[i][2]=ex.getData("Sheet5", i+1, 2);
		  data[i][3]=ex.getData("Sheet5", i+1, 3);
    
	  }
	  return data;
  }
}