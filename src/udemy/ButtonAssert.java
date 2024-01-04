package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ButtonAssert {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
	     System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		
		driver.close();
	}

}
