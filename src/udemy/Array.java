package udemy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Array {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		int j=0;
		String[] items= {"Brocolli","Cucumber","Carrot","Beans"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		
		for(int i=0;i<products.size();i++)
		{
			// split Brocolli - 1kg
			
			String[] name = products.get(i).getText().split("-");
			String trimmedname = name[0].trim();
			// name[0] = brocolli
			// name[1] = 1kg
			//convert array into array list
			//check name extracted is present in array list or not
			
			List<String> itemlist = Arrays.asList(items);
			
			if(itemlist.contains(trimmedname))
			{
				j++;
				// Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==items.length)
				{
					break;
				}
				
			}
		}
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']"))).getText();
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		 WebElement country = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		Select s= new Select(country);
		s.selectByVisibleText("India");
		driver.findElement(By.cssSelector("[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();		
					
	}
}
