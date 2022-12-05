package wipro.greatlearning.GradedAssignment;

public class Book {
	
	String[] description = { "Ulysses by James Joyce", "Don Quixote by Miguel de Cervantes","One Hundred Years of Solitude by Gabriel Garcia Marquez", "Hamlet by William Shakespeare","In Search of Lost Time by Marcel Proust" };
	String[] authorName = { "James Joyce", "Miguel de Cervantes", "Gabriel Garcia Marquez", "William Shakespeare","Marcel Proust" };
	String[] bookName = { "Ulysses", "Don Quixote", "One Hundred Years of Solitude", "Hamlet","In Search of Lost Time" };
	int[] bookId = { 110, 220, 330, 440, 550, 660 };
	
//getBookDetails method returns the book details of a particular book	
public void getBookDetails(String s) {
	int y=-1;
	for(int i=0;i<bookName.length;i++) {
		if(bookName[i].equalsIgnoreCase(s)) {
			y=i;
			break;
		}
	}
	if(y==-1) System.out.println("Book not found!");
	else {
	System.out.println("Author Name: "+authorName[y]);
	System.out.println("Description: "+description[y]);}
	
}
	
}
