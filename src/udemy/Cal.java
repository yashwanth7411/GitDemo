package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cal {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("(//a[text()='Send email'])[1]"))).click();
		System.out.println(driver.findElement(By.xpath("(//a[text()='Send email'])[1]")).getText());
		//driver.findElement(By.xpath("(//a[text()='Send email'])[1]")).click();
	}

}
