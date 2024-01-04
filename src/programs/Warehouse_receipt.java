package programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Warehouse_receipt {
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
		driver.findElement(By.id("atabWarehouseReceipts")).click();
		// Click on Export Warehouse Receipts
		driver.findElement(By.xpath("//button[text()='Export Warehouse Receipts']")).click();
		//Click on Expected UPCs Report
		driver.findElement(By.xpath("//button[text()='Expected UPCs Report']")).click();
	/*	//Click on Export Warehouse Expected Receipts
		driver.findElement(By.xpath("//button[text()='Export Warehouse Expected Receipts']")).click();
		driver.findElement(By.id("ag-927-input")).click();
		driver.findElement(By.id("generate-warehouse-expected-receipts-button")).click();  */
		
		
		
		
	}
}
