package addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Dictionary {
	 Scanner sc=new Scanner(System.in);
	public  String name;
	public  Map<String, List<Contact>> dictionary=new HashMap<String, List<Contact>>();
	public  ArrayList<AddressBook> ObectsSet=new ArrayList<AddressBook>();
	Map<String, List<Contact>> map=new HashMap<String, List<Contact>>();
	
	
	public void AddBook()
	{
		System.out.println("give a name to your AddressBook..");
		 name=sc.next();
		if(dictionary.containsKey(name))
			System.out.println("book exist .Please try another name");
		else
		{
			AddressBook book=new AddressBook(name);
			book.setName(name);
			book.welcome();
			ArrayList<Contact> listOfContacts=book.ReturnListOfContacts();
			dictionary.put(name, listOfContacts);
			System.out.println(dictionary);
			
			ObectsSet.add(book);
			System.out.println(ObectsSet);
		}
	}
	public void OpenExisting()
	{
		AddressBook book=null;
		System.out.println("select Addressbook from below list: "+dictionary.keySet());
		name=sc.next();
		boolean flag=true;
		for(AddressBook b:ObectsSet)
		{
			if(b.getName().equalsIgnoreCase(name))
			{
				book=b;
				b.ReturnListOfContacts();
				b.welcome();
				flag=false;
			}
				
			
		}
		if(flag==true)
			System.out.println("there is no addressbook with this name.");

	}
	public void SearchPerson()
	{
		System.out.println("Enter city");
		String city=sc.next();
		for(AddressBook b:ObectsSet)
		{
			b.searchPerson(city);
		}
	}
	
	public void SortByCity()
	{
		
		Set<String> s=new HashSet<String>();
		for(AddressBook b:ObectsSet)
		{
			List<Contact> c=b.ReturnListOfContacts();
			List<String> distinctCity=c.stream().map(Contact::getCity).distinct().collect(Collectors.toList());
			s.addAll(distinctCity);
		}
		for (String city : s)
		{
			ArrayList<Contact> c=new ArrayList<Contact>();
			for(AddressBook b:ObectsSet)
			{
				c.addAll(b.viewByCity(city));
			}
			map.put(city, c);
		}
		
	}
	public void countByCity()
	{
		Map<String, Integer> m=new HashMap<String, Integer>();
		SortByCity();
		Set<String> keyset=map.keySet();
		for (String s : keyset)
		{
			Integer count=map.get(s).size();
			m.put(s, count);
		}
		
		System.out.println(m);
	}
	
	public void initialize()  
	{
		
		System.out.println("Welcome to AddressBook management...");
		System.out.println("type 1 to add new AddressBook");
		System.out.println("type 2 to enter into present AddressBook");
		System.out.println("type 3 to search person");
		System.out.println("type 4 to sort list by city");
		System.out.println("type 5 to count person by city");
		int option;
		do
		{
			System.out.println("Enter operation number..");
			option=sc.nextInt();
			if(option==0)
				return;
			switch(option)
			{
				case 1: 
					AddBook();
					break;
				case 2:
					OpenExisting();
					break;
				case 3:
					SearchPerson();
					break;
				case 4:
					SortByCity();
					System.out.println(map);
					break;
				case 5:
					countByCity();
					break;
				default:
					System.out.println("invalid operation");
			}
		}
		while(option!=0);
		
	}
	
		
}
