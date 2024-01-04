package javaStreams;

public class Intp2 extends Intp3{
	int a;
	
	
	public Intp2(int a) 
	{
		super(a);  // Parent class constructoris invoked
		this.a=a;
	}

	public int increment()
	{
		a=a+1;
		return a;
	}
	
	public int decrement()
	{
		a=a-1;
		return a;
	}

}
