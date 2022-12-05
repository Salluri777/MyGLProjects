package Service;

public class Admin {
	String name="Admin";
	
	//function to check whether the logging person is admin or not
	
	public int check(String n) {
		if(name.equalsIgnoreCase(n)){
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
