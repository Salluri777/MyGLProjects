package wipro.greatlearning.GradedAssignment;
import java.util.Scanner;

public class MagicOfBooks {
	 static Scanner input = new Scanner(System.in);
	 static User person = new User();
	 static Book books = new Book();
	 static Thread t1 = new Thread(new ThreadDemo());
	 
	public static void main(String[] args) throws MyCustomException{
		 
		 String name;
		 int id;
		 t1.start();
		 name=input.nextLine();
		 //Calling the user checker method which checks for the user name in the user data.
		 UserChecker(name);
		
	}
	//UserChecker method starts from here
		public static void UserChecker(String Name) throws MyCustomException {
			int c=0;
			for(String s:person.Usernames) {
				if(s.equalsIgnoreCase(Name)) {
					c++;
				}
			}
			if(c!=0) {
				System.out.println("Welcome "+Name+"!");
				UserMenu(Name);	
			}
			else {
				System.out.println("Sorry! You are not an authorized user");
				System.exit(1);
			}
		}
		//UserMenu method which displays Menu
		public static void UserMenu(String name) throws MyCustomException {
			t1.setPriority(10);
			while(true) {
				System.out.println("**************MENU***********");
				System.out.println("1.Print your books(new,favourite,completed)");
				System.out.println("2.Find book by bookId");
				System.out.println("3.Print the details of a book");
				System.out.println("Please enter your choice:");
				int c2 = input.nextInt();
				input.nextLine();
				try {
				switch(c2) {
				case 1: userBooksDetails(name);
						//userBookDetails method prints the books details of a particular user
						break;
				case 2:bookId();
						//bookId method tells whether the book is available or not based on book Id
						break;
				case 3: bookDetails();	
						//book Details method gives the book details by giving the book name
						break;
				}
				}catch(Exception e) {
					System.out.println("you entered invalid number!!!!");
				}
				System.out.println("Do you want to continue?");
				
				String str = input.next();
				input.nextLine();
				if(str==null) {
					throw new MyCustomException("String contains null value");
				}
				if(str.equalsIgnoreCase("NO")) {
					System.exit(1);
					break;
				}
				else {
					System.out.println("Please enter your username:");
					String extraname = input.nextLine();
					UserChecker(extraname);
					
				}	
		}
	}
		 //bookDetails method starts from here
		private static void bookDetails() {
			//System.out.println("Enter your book name:");
			 String bname = input.nextLine();
			 books.getBookDetails(bname);
		
		}
		//bookId method starts from here
		public static void bookId() {
			 System.out.println("Please enter your book id");
			 int id=input.nextInt();input.nextLine();
			 int s=0;
			 for(int i:books.bookId) {
				 if(i==id) s++;
			 }
			 if(s==0) {
				 System.out.println("Unavailable");
			 }
			 else System.out.println("Available");
		
		}
		//userBookDetails method starts from here
		public static void userBooksDetails(String N) {
			person.setUserDetails(N);
			String[] New=person.usrInformation.get(N).get("New Books:").split(",");
			String[] Favourite=person.usrInformation.get(N).get("Favourite Books:").split(",");
			String[] Completed=person.usrInformation.get(N).get("Completed Books:").split(",");
			System.out.println("New Books:");
			for(String b:New) {
				System.out.println(b);
				
			}
			System.out.println("Favourite Books:");
			for(String k:Favourite) {
				System.out.println(k);
			}
			System.out.println("Completed Books:");
			for(String m:Completed) {
				System.out.println(m);
			}
			
		}
		
}
