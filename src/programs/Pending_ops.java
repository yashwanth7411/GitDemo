package programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Pending_ops extends Create_po {
/*	@Test
	public void operation() throws Throwable { */
	
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
		
		//pending ops i/p
		
	//	Thread.sleep(5000);
		WebDriverWait w=new WebDriverWait(driver, 10);
		//click on Pendings ops tab
		WebElement operationtab = driver.findElement(By.xpath("(//a[@class='c-sidebar-nav-link'])[4]"));
		w.until(ExpectedConditions.elementToBeClickable(operationtab)).click();
		//click on PO
		driver.findElement(By.xpath("//a[text()='1053']")).click();
		driver.findElement(By.id("submitpo")).click();
		w.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		// PO detail [Reveived QTY and Received date ] 
		driver.findElement(By.id("ag-123-input")).click();
		driver.findElement(By.id("OpsSkuViewModel_ManualReceipts")).sendKeys("45");
		driver.findElement(By.id("OpsSkuViewModel_ManualReceiveOn")).sendKeys("11302023");
		driver.findElement(By.id("btnnewSku")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.id("btnnewSku")));
		driver.findElement(By.xpath("//button[@id='sendtoReview']")).click();		
		
	}
}
