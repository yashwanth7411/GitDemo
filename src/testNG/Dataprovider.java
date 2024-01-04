package testNG;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	@Test(groups= {"Smoke"})
	public void Basic()
	{
		System.out.println("Selenium");
	}
	
	@AfterSuite
	public void Selenium()
	{
		System.out.println("After suite Execute Automation with Java");
	}
	
	
	@Test(dataProvider= "getdata")
	public void dataprovide(HashMap<String, String> input)
	{
		System.out.println("Data Provider to get data");
		System.out.println(input.get("un"));
		System.out.println(input.get("pwd"));
	}
/*	@DataProvider
	public Object[][] getdata()
	{
		//1st combination username pwd -- good credit score
		//2nd username and pwd -- average credit score
		//3rd fraudelent credit score
		Object data[][]=new Object[3][2];
		//1st set
		data[0][0]="firstset username";
		data[0][1]="password";
		
		//2nd set
		data[1][0]="second username";
		data[1][1]="second password";
		
		//3rd set
		data[2][0]="Third username";
		data[2][1]="Third password";
		return data;   */
		
		@DataProvider
		public Object[][] getdata()
		{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("un","First Username");
		map.put("pwd", "First Password");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("un", "Second Username");
		map1.put("pwd", "Second Password");
		
		HashMap<String,String> map2=new HashMap<String,String>();
		map2.put("un", "Third Username");
		map2.put("pwd", "Third Password");
		return new Object[] []  {{map}, {map1 }, {map2} };

		
	}
}
