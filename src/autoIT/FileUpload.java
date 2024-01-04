package autoIT;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/excel_to_pdf");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		
		//Auto IT Execution
		Runtime.getRuntime().exec("D:\\PIP\\Automation\\fileupload.exe");
	//	WebElement downloadbtn = driver.findElement(By.id("processTaskTextBtn"));
		WebDriverWait w=new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn"))).click();
	/*	File f=new File("C:\\Users\\Yashwanth\\2713Decor");
		if(f.exists())
		{
			System.out.println("File Found");
		}
		System.out.println("File Not Found");  */
	}
}
