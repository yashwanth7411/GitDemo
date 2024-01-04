package data_driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	
	@Test
	public void exceldata() throws Throwable
	{
	FileInputStream fis=new FileInputStream("D:\\PIP\\excelDriven.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheetAt(0);
	int rowcount = sheet.getPhysicalNumberOfRows();
	XSSFRow row = sheet.getRow(0);
	int colcount = row.getLastCellNum();
	Object data[][]=new Object [rowcount-1][colcount];
	
	for(int i=0;i<rowcount-1;i++)
	{
		System.out.println("Outer loop started");
		row=sheet.getRow(i+1);
		for(int j=0;j<colcount;j++)
		{
			System.out.println(row.getCell(j));
		}
		System.out.println("Outer loop Ended");
	}
}
}
