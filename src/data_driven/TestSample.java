package data_driven;

import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Datadriven d=new Datadriven();
		ArrayList<String> data=d.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		

	}

}
