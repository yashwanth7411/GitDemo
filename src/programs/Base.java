package programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Base {
	
/*	@BeforeTest 
	public void login() throws Throwable
	{	*/
	   public static void main(String[] args) throws Throwable
	   {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://qapotracker.azurewebsites.net/");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("loginfmt")).sendKeys("yk@balsambrands.com");
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.name("passwd")).sendKeys("Yash1234@");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9"))).click();
	//	driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("KmsiCheckboxField")).click();
		WebElement yes = driver.findElement(By.id("idSIButton9"));
		wait.until(ExpectedConditions.elementToBeClickable(yes));
		yes.click();
		
	}
}
