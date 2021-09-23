package day3;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingExcel
{

	public static void main(String[] args) throws Exception
	{   // .xls --> HSSF
		// .xlsx -> XSSF
		// 1.Reading workbook
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream("D:\\LTI\\TRAINING\\SELJARS\\data.xlsX"));
		
		//2.Reading Sheet
		XSSFSheet sh=wb.getSheet("Sheet1");
		
		//3.Reading from cells( row, col)
		String data=sh.getRow(1).getCell(0).toString();
		System.out.println(data);
		
		
		for(int i=0;i<=3;i++)
		{
			String user=sh.getRow(i).getCell(0).toString();
			System.out.print(user+" ");
			String pass=sh.getRow(i).getCell(1).toString();
			System.out.println(pass);
			System.out.println();
			
			
		}

	}

}
