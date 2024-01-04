package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Ass {
	public static void main(String[] args) throws Throwable
		{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("__disable-notifications");
		opt.addArguments("__disable-geolocation");
		WebDriver driver=new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		driver.get("http://spicejet.com"); //URL in the browser
		
		Assert.assertFalse(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());
		
		driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());
			
		
	}
		
	}


