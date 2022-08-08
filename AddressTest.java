package addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressTest {
	static Scanner sc=new Scanner(System.in);
	public static String name;
	public static Map<String, List<Contact>> dictionary=new HashMap<String, List<Contact>>();
	public static ArrayList<AddressBook> ObectsSet=new ArrayList<AddressBook>();
	public static void initialize()  
	{
		
		System.out.println("Welcome to AddressBook management...");
		System.out.println("type 1 to add new AddressBook");
		System.out.println("type 2 to enter into present AddressBook");
		int option;
		do
		{
			System.out.println("Enter operation number..");
			option=sc.nextInt();
			if(option==0)
				return;
			else if(option==1)
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
			else if(option==2)
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
			
			else System.out.println("invalid operation");
		}
		while(option!=0);
		
	}
	public static void main(String[] args) {
		initialize();
		System.out.println(dictionary);
	}
		
}
