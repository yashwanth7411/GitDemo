package data_driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	
	@SuppressWarnings("deprecation")
	public ArrayList<String> getData(String testcaseName) throws Throwable
	{
		//FileInputStream argument
		
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("D://PIP//test.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("data"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//Identify test cases column by scanning the enire first row
				
				Iterator<Row> rows = sheet.iterator(); //Sheet is collection of Rows
				Row Firstrow = rows.next();
				Iterator<Cell> ce=Firstrow.cellIterator(); //Row is a collection of Cells
				int k=0;
				int column = 0;
				while(ce.hasNext())
				{
					Cell ce_value = ce.next();
					if(ce_value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						// desired column no
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				
				while(rows.hasNext())
				{
					Row ro = rows.next();
					if(ro.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						/// After grab login testcase row = pull all the data of that row
						
						Iterator<Cell> cv = ro.cellIterator();
						while(cv.hasNext())
						{
							Cell c = cv.next();
							
							if(c.getCellTypeEnum()==CellType.STRING)
							{
								a.add(cv.next().getStringCellValue());
							}
							else
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
							
						}
					}
				}
			}
			
		}
		return a;
		
	}
		public static <List> void main(String args[]) throws Throwable
		{
	}

}
