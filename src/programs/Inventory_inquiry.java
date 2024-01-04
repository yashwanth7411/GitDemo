package programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Inventory_inquiry {
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
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9"))).click();
	//	driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("KmsiCheckboxField")).click();
		WebElement yes = driver.findElement(By.id("idSIButton9"));
		wait.until(ExpectedConditions.elementToBeClickable(yes));
		yes.click();
		
	              //  Inventory Inquiry page
		WebDriverWait w=new WebDriverWait(driver, 10);
		WebElement Inv = driver.findElement(By.cssSelector("a[href='/PurchaseOrder/InventoryEnquiry']"));
		Actions a = new Actions(driver);
		a.moveToElement(Inv).click().build().perform();
		WebElement po_num = driver.findElement(By.id("InventoryEnquiryFilterViewModel_PoNumber"));
		po_num.sendKeys("2563");
		driver.findElement(By.id("filter-submit")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='expandAll()']"))).click();
	//	driver.findElement(By.xpath("//button[@onclick='expandAll()']")).click();
		driver.findElement(By.id("excelExportInventory")).click();
	}
}
