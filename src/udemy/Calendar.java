package udemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.path2usa.com/travel-companion/");
		Thread.sleep(5000);
		//august 23 
		Actions a = new Actions(driver);
		WebElement cal = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		Thread.sleep(5000);
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(209, 1359)");
		cal.click();
		WebDriverWait w=new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(cal)).click();
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day "));
		
		int count = driver.findElements(By.className("flatpickr-day ")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("flatpickr-day ")).get(i).getText();
			if(text.equalsIgnoreCase("23"))
			{
				driver.findElements(By.className("flatpickr-day ")).get(i).click();
				break;
			}
		}
		
	}


}
