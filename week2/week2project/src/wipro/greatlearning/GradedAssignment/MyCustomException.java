package wipro.greatlearning.GradedAssignment;

public class MyCustomException extends Exception {
	String s;
	MyCustomException(String s){
		super(s);
		if(s.equals(null)) {
			System.out.println("String contains null value");
		}
	}

}
