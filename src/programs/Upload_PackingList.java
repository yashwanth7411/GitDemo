package programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Upload_PackingList {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://qapotracker.azurewebsites.net/");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("loginfmt")).sendKeys("yk@balsambrands.com");
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.name("passwd")).sendKeys("Yash1234@");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9"))).click();
	//	driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("KmsiCheckboxField")).click();
		WebElement yes = driver.findElement(By.id("idSIButton9"));
		wait.until(ExpectedConditions.elementToBeClickable(yes));
		yes.click();  
		
		// Packing List
		WebDriverWait w=new WebDriverWait(driver, 10);
		WebElement Packing_list = driver.findElement(By.cssSelector("a[href='/GIT']"));
	//	w.until(ExpectedConditions.elementToBeClickable(Packing_list)).click();
		Actions a=new Actions(driver);
		a.moveToElement(Packing_list).click().build().perform();
		//Release QA Decor
		driver.findElement(By.xpath("//div[text()='QA_Decor']")).click();
		driver.findElement(By.id("atabPendingListDetails")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-load-packing-list']")).click();
		driver.findElement(By.id("select2-lpl-warehouse-container")).click();
		driver.findElement(By.xpath("//li[text()='Amware']")).click();
		driver.findElement(By.xpath("//span[text()='Select Destination Port']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Savannah')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='form-group col-md-12'])[17]")).click();
		Thread.sleep(2000);
		
		//File Upload
		Runtime.getRuntime().exec("D:\\PIP\\Automation\\fileupload.exe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Upload File']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='modal-btn-container'])[5]")).click();
		driver.switchTo().alert().accept();
	}
}
