package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Pgm1 {
	@Test(groups= {"Smoke"})
	public void Demo()
	{
		System.out.println("Hello World");
	}
	
	@Test
	public void Second()
	{
		Assert.assertTrue(false);
		System.out.println("After every test Finally say Bye");
	}
	

}
