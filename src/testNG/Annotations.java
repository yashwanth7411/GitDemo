package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotations {
	
	@Test(dependsOnMethods= {"Packinglist"})
	public void userinventory()
	{
		System.out.println("PO Creation");
	}
	
	@BeforeClass
	public void befclass()
	{
		System.out.println("Before executing any method in class ");
	}
	
	@AfterClass
	public void aftclass()
	{
		System.out.println("After executing any method in class ");
	}
	@BeforeMethod
	public void useroperation()
	{
		System.out.println("Before every Method Operations on PO");
	}
	
	@Test(groups= {"Smoke"})
	public void Packinglist()
	{
		System.out.println("Decor &  PG");
	}

	@Test(enabled=false)
	public void warehouse()
	{
		System.out.println("Warehouse receipts");
	}
	
	@Parameters({"URL","APIkey"})
	@Test
	public void userAccounts(String urlname, String key)
	{
		System.out.println("Before suite Accounts on PO");
		System.out.println(urlname);
		System.out.println(key);
	}
}
