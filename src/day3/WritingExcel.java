package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel 
{

	public static void main(String[] args) throws Exception
	{
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream("D:\\LTI\\TRAINING\\SELJARS\\data.xlsX"));
		
		XSSFSheet sh=wb.getSheet("Sheet1");
		//both exist
		sh.getRow(1).getCell(1).setCellValue("hr$$$");
		
		//row exist
		sh.getRow(1).createCell(2).setCellValue("correct");
		
		//both does not exist
		sh.createRow(4).createCell(2).setCellValue("Noice");
		
		
		wb.write(new FileOutputStream("D:\\LTI\\TRAINING\\SELJARS\\newdata.xlsX"));
		

	}

}
