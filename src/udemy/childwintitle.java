package udemy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class childwintitle {
	public static void main (String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		// 1. give me the count of all the links in the webpage 
		//a 
		//2. count of links in footer section
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Limiting WebDriver scope
		WebElement foot = driver.findElement(By.id("gf-BIG"));
		System.out.println(foot.findElements(By.tagName("a")).size());
		
		//3. count of links in footer section --column
		WebElement footcolumn = foot.findElement(By.xpath("(//div[@id='gf-BIG']//td[1])"));
		System.out.println(footcolumn.findElements(By.tagName("a")).size());
		
		//4. click on each link in the column and check if they are opening
		Actions a=new Actions(driver);
		for(int i=0;i<footcolumn.findElements(By.tagName("a")).size();i++)
		{
		//	String linkclick = Keys.chord(Keys.CONTROL,Keys.ENTER);
			WebElement linkclick = footcolumn.findElements(By.tagName("a")).get(i);
			a.keyDown(linkclick, Keys.CONTROL).build().perform();
			Thread.sleep(3000);
			
		} // opens all the tabs
		
			Set<String> tit = driver.getWindowHandles();
			Iterator<String> it = tit.iterator();
			
			while(it.hasNext())  // checks for the next window 
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
	}

}
