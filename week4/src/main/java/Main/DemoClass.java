package Main;
import Service.Admin;
import Service.operations;

import java.util.Scanner;
import Entity.BookStore;


public class DemoClass {

	public static void main(String[] args) {
		
		Admin Ad = new Admin();
		int id;
		String name;
		int checking;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter enter your role(Admin/User):-");
		name =sc.nextLine();
		checking=Ad.check(name);
		if(checking==1) {
			Menu();
		}
		else {
				System.out.println("Invalid Role!.");
				System.out.println("Please ReEnter");
				System.out.println("Enter enter your role(Amin/User):-");
				name =sc.nextLine();
				checking=Ad.check(name);
				if(checking==1) {
					Menu();
				}
		}
	}
		public static void Menu(){
			Scanner sc = new Scanner(System.in);
			operations meth = new operations();
			String response;
			int id;
		do {
		System.out.println("**********MENU***********");
		System.out.println("1.Add a Book");
		System.out.println("2.Delete a Book");
		System.out.println("3.Update a Book");
		System.out.println("4.Display the Books");
		System.out.println("Please enter your choice:");
		int choice =sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
		   System.out.println("Enter Book name");
		   String BName=sc.nextLine();
		   System.out.println("Enter Book Genre");
		   String Gen = sc.nextLine();
		   System.out.println("Enter Book Author");
		   String AName = sc.nextLine();
		   System.out.println("Enter Book description");
		   String Desc = sc.nextLine();
		   System.out.println("Enter Book price");
		   Float p = sc.nextFloat();sc.nextLine();
		   System.out.println("Enter nymber of Copies sold");
		   int Qn = sc.nextInt();
		   BookStore newBook = new BookStore(BName,AName,Desc,Gen,p,Qn);
		   meth.AddBook(newBook);
		   break;
	  case 2:meth.display();
		   System.out.println("Enter the book id that you want to delete");
		   id = sc.nextInt();
		   meth.deleteBook(id);
		   break;
	  case 3:meth.display();
		   System.out.println("Please enter the Book name id you want to update");
	   	   id = sc.nextInt();
	   	   System.out.println("Enter the choice of the entity that u want to change:");
		   System.out.println("1.BookName 2.AuthorName 3.Price ");
		   meth.updateBook(id);
		   break;
		  
	case 4: System.out.println("1.Display Book Count");
			System.out.println("2.Display via Genre");
			System.out.println("3.Book Information");
			System.out.println("4.Arrange price low to high");
			System.out.println("5.Arrange price high to low");
			System.out.println("6.Arrange best selling on Top");
			System.out.println("Please enter your choice");
			int ch = sc.nextInt();sc.nextLine();
			switch(ch) {
			case 1:	meth.BooksCount();
		       		break;
			case 2: 
					System.out.println("Please Enter the genre");
					String gen = sc.nextLine();
					meth.Genre(gen);
		       		break;
			case 3:	meth.display();
					break;
			case 4: meth.ascend();
      				break;
			case 5:	meth.descend();
      				break;
			case 6: meth.Bestselling();
            		break;
			default:
			}
			break;
		   
	default:System.out.println("Enter Valid Option");
		   
	}
		System.out.println("Do you want to continue ?");
		 response = sc.next();
		}while(response.equalsIgnoreCase("yes"));

	
	if(response.equalsIgnoreCase("no")) {
		System.out.println("Press 1 for main Menu and 0 for exit");
		int m =sc.nextInt();
		if(m==0) {
			System.out.println("Thank You! ");
			sc.close();
		}
		else {
			Menu();
		}
	}
		}

}

