package addressbooksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	Scanner s = new Scanner(System.in);
	ArrayList<Contact> list = new ArrayList<Contact>();
	Contact person1 = new Contact();
	Address address = new Address();
	
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
		address.setCity(city);

		System.out.println("Enter the Zip:");
		long zip = s.nextLong();
		address.setZip(zip);

		System.out.println("Enter the State:");
		String state = s.next();
		address.setState(state);
		person1.setAddress(address);
		list.add(person1);
		System.out.println("Contact added into book");
	}
	
	void PrintContact()
	{
		
		
		String total=person1.toString()+address.toString();
		System.out.println(total);
	}


}
