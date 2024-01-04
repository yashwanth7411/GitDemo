package udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edgebrowser {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		WebDriver driver= new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
	}

}
