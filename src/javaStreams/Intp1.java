package javaStreams;

import org.testng.annotations.Test;

public class Intp1 extends Inheritance{
	
	@Test
	public void testRun()
	{
		Intp2 p2=new Intp2(3);      // parameterized constructor
		int a=3;
	//	demo();
		System.out.println(p2.increment());
		System.out.println(p2.decrement());
		   // parameterized constructor
		
		System.out.println(p2.multiplythree());
	}

}
