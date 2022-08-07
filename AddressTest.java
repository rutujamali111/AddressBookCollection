package addressbooksystem;

import java.util.Scanner;

public class AddressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddressBook book1=new AddressBook();
		Scanner sc=new Scanner(System.in);
		int option;
		do
		{
			System.out.println("--- Address Book Management ---\n");
            System.out.println("\t--MENU--");
			System.out.println("Enter operation number..");
			option=sc.nextInt();
			if(option==0)
			{
				System.exit(0);
			}
			switch (option)
			{
			case 1:
				book1.add();
				break;
			case 2:
				book1.PrintContact();
				break;
			case 3:
				book1.edit();
				break;
			case 4:
				book1.delete();
				break;
			default:
				break;
			}
			 System.out.println("Enter zero to exit     \n");
            System.out.println("1: Add New Person      ");
            System.out.println("2: Display Records     ");
            System.out.println("3: Edit Person     ");
            System.out.println("4: Delete Person     ");
           
		}
		while(option!=0);
	}

}
