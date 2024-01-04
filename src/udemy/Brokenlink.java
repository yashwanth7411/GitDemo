package udemy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlink {
	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//broken URL
		//step 1- get all urls tied up to the links using selenium
		// java method will call url and get the http statu code
		// if status code > 400, then the url is broken
		// $('a[href="soapui"]')
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> lists = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert s= new SoftAssert();
		for(WebElement link:lists)
		{
			
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode=conn.getResponseCode();
			System.out.println(respCode);
			s.assertTrue(respCode<400, "The link with text: " +link.getText()+ " is broken link with code " +respCode);				
		}
			s.assertAll();
	}
}
