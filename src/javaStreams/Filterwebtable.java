package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filterwebtable {
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> items = driver.findElements(By.xpath("//tr//td[1]"));
		//5 results should search for rice
		List<WebElement> filtereditems = items.stream().filter(s->s.getText().contains("Rice"))
				.collect(Collectors.toList());
		//After filter 1 result rice
		Assert.assertEquals(items.size(),filtereditems.size());
		System.out.println("Item Found");
	}

}
