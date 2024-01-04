package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Pgm1 {	
	//count the number of names starts with alphabet A
//	@Test
	public void regular()
	{
	ArrayList<String> names = new ArrayList<String>();
		names.add("Subba");
		names.add("AbhishekLikith");
		names.add("Ravi");
		names.add("Ashwin");
		names.add("Anil");
		int count=0;
		for(int i=0;i<names.size();i++)
		{
			String friends = names.get(i);
			if(friends.startsWith("A"))
			{
				count++;
				System.out.println(friends);
			}
		}
		System.out.println(count);
	}

	
//	@Test
	public void StreamFilter()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Akash");
		names.add("Harish");
		names.add("Arun");
		names.add("Shashi");
		names.add("Manu");
		
		// arraylist to streams, where you can use streams methods
		//  lamda expression left side parameter, right side action for the parameter
		long list = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(list);
		
		// there is no life of intermidiate ops if there is no terminal op
		//terminal operation is executed when only intermidiate ops is "True"
		long d = Stream.of("Akash","Harish","Arun","Shashi","Anu").filter(a->
		{
			a.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		
		 //print all the names of ArrayList 
	//	names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//limit the output if there are 3 o/p limit it to 2 or 1
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}
	
	
//	@Test
	public void StreamMap()
	{
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Subba");
		names.add("Abhi");
		names.add("Likith");
		names.add("Ashwin");
		//print names which have last letter as "h" with uppercase
		Stream.of("Arun","Harish","Akash","Manu","Tharun").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//print names which have first letter a with uppercase and sorted
		
		List<String> names1= Arrays.asList("Arun","Harish","Akash","Manu","Tharun");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//merging 2 diff streams and print all the names
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
	//	newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("SuBBa"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
	}
	
	
	@Test
	public void streamCollect()
	{
		List<String> ls = Stream.of("Arun","Harish","Akash","Manu","Tharun").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//print unique values
		//sort the array
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		// o/p 1,2,3,5,7,9,
		//sort and give me the 3rd index
		List<Integer> sortedList = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedList.get(2));
	}
	
}
