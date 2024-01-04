package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Webtabsorted {
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column header
		// capture all the webelement to list
		// capture text of all webelement to new (original) list
		// sort the new list --  sorted list
		// compare new list vs sorted list
		
		//click on column header
		driver.findElement(By.xpath("(//th[@role='columnheader'])[1]")).click();
		
		// capture all the webelement to list
		List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
		
		// capture text of all webelement to new (original) list
		List<String> orgList=list.stream().map(s->s.getText()).collect(Collectors.toList());
		 
		// compare new list vs sorted list
		List<String> sortList=orgList.stream().sorted().collect(Collectors.toList());
		
		
		Assert.assertTrue(orgList.equals(sortList));
		
		//scan the column with getText--> Beans and print price of Rice
		
		List<String> price;
		do {
			
		List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));	
		price = rows.stream().filter(s->s.getText().contains("Rice")).
		map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}		while(price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
}
