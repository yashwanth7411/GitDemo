package data_driven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {
	
	DataFormatter formater=new DataFormatter();
	@Test(dataProvider="driveTest")
	public void TestCaseData(String greeting, String message, String id)
	{
	
		System.out.println(greeting + message + id);
	}
		@DataProvider(name="driveTest")
		public Object[][] getdata() throws Throwable
		{
	//	Object [][] data = { {"hello","text","1"},{"GM", "forward", "143"},{"test","call","234"} };
		//	every row data should be sent to 1 array in total 3 array
			FileInputStream fis=new FileInputStream("D:\\PIP\\excelDriven.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowcount = sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int colcount = row.getLastCellNum();
			Object data[][]=new Object [rowcount-1][colcount];
			
			for(int i=0;i<rowcount-1;i++)
			{
				row=sheet.getRow(i+1);
				for(int j=0;j<colcount;j++)
				{
					XSSFCell cell = row.getCell(j);
					data[i][j]=formater.formatCellValue(cell);
				}
			}
			
			return data;
	}

}
