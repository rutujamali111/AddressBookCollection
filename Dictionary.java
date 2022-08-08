package addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	
	public void initialize()  
	{
		
		System.out.println("Welcome to AddressBook management...");
		System.out.println("type 1 to add new AddressBook");
		System.out.println("type 2 to enter into present AddressBook");
		System.out.println("type 3 to search person");
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
				default:
					System.out.println("invalid operation");
			}
		}
		while(option!=0);
		
	}
	
		
}
