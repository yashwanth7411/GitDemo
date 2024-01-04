package javaStreams;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Inheritance {
	
	
	@Test
	public void demo()
	{
		System.out.println("Demo on Inheritance");
	}
	@BeforeTest
	public void after()
	{
		System.out.println("Run me first");
	}

}
