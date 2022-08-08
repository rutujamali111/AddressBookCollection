package addressbooksystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook{
	String name;
	public AddressBook(String name)
	{
		name=this.name;
	}
	Scanner s = new Scanner(System.in);
	ArrayList<Contact> list = new ArrayList<Contact>();
	Contact person1 = new Contact();
//	Address address = new Address();
	
	public void welcome(String name2) {
		
		System.out.println("welcome to "+name2+" directory");
		System.out.println("Want to perform any operation ? then type 1");
		int option=s.nextInt();
		if(option==1)
		{
			start();
		}
		else if(option==2)
		{
			PrintContact();
		}
		else
			System.out.println("Invalid operation select");
	}
	
	public void start()
	{
		int option;
		do
		{
				System.out.println("--- Address Book Management ---\n");
				System.out.println("\t--MENU--");
			 	System.out.println("Enter zero to exit     \n");
		        System.out.println("1: Add New Person      ");
		        System.out.println("2: Display Records     ");
		        System.out.println("3: Edit Person     ");
		        System.out.println("4: Delete Person     ");
		
		        System.out.println("Enter operation number..");
			option=s.nextInt();
			if(option==0)
			{
				return;
			}
			switch (option)
			{
			case 1:
				add();
				break;
			case 2:
				PrintContact();
				break;
			case 3:
				edit();
				break;
			case 4:
				delete();
				break;
			default:
				System.out.println("Invalid operation select");
				break;
			}
	       
		}
		while(option!=0);
	}

	
	
	public void add() {
		
		System.out.println("Enter the First name:");
		String fname = s.next();
		person1.setFname(fname);

		System.out.println("Enter the Last name:");
		String lname = s.next();
		person1.setLname(lname);

		System.out.println("Enter the Phone Number:");
		Long phone = s.nextLong();
		person1.setPhonenumber(phone);

		System.out.println("Enter the City:");
		String city = s.next();
		person1.setCity(city);
		
		System.out.println("Enter the Zip:");
		long zip = s.nextLong();
		person1.setZip(zip);

		System.out.println("Enter the State:");
		String state = s.next();
		person1.setState(state);
		
		list.add(person1);
		System.out.println("Contact added into "+name);
	}
	
	public ArrayList<Contact> ReturnListOfContacts()
	{
		return list;
	}
	
	public void edit() {
		System.out.println("Enter your First name:");
		String fname = s.next();

		Iterator<Contact> iterator = list.listIterator();

		while (iterator.hasNext()) {
			Contact person = iterator.next();

			if (fname.equalsIgnoreCase(person.getFname())) {
				//Address address = person.getAddress();
				System.out.println("Choose field you want to edit:");
				System.out
						.println("1.Last Name\t2.Phone Number\t3.City\t4.Zip\t5. State");
				switch (s.nextInt()) {
				case 1:
					System.out.println("Re-Correct your lastname");
					person.setLname(s.next());
					break;
				case 2:
					System.out.println("Re-Correct your Phone Number");
					person.setPhonenumber(s.nextLong());
					break;
				case 3:
					System.out.println("Re-Correct your City");
					person.setCity(s.next());
					break;
				case 4:
					System.out.println("Re-Correct your Zip");
					person.setZip(s.nextLong());
					break;
				case 5:
					System.out.println("Re-Correct your State");
					person.setState(s.next());
					break;
				}

			}
		}
		System.out.println("contact Edited");

	}
	
	public void delete() {
		System.out.println("Enter your First name:");
		String fname = s.next();

		Iterator<Contact> iterator = list.listIterator();
		while (iterator.hasNext()&&list.size()!=0) {
			Contact person = iterator.next();

			if (fname.equals(person.getFname())) {
				list.remove(person);
			}
		}
		System.out.println("contact deleted");
	}



	public void PrintContact() {
		// TODO Auto-generated method stub
		System.out.println("contacts in dictionary" +name );
		System.out.println(list);
		
	}



	

}
