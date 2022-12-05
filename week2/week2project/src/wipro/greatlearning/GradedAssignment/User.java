package wipro.greatlearning.GradedAssignment;
import java.util.*;

public class User {

		private int userId;
		private String emailId;
		 String[] Usernames = {"Adam Sandler","Tom Hanks","Tom Cruise","Angelina Jolie","Scarlett Johansson"};
		 String[] userEmails = {"Adamsandler123@gmail.com","Tomcruise123@gmail.com","AngelinaJolie123@gmail.com","Scarlettjohansson123@gmail.com"};
		 String[] userPasswords = {"AdamSandler123","TomCruise123","AngelinaJolie123","ScarlettJohansson123"};
		 HashMap<String,String> UsrDetails=new HashMap<>();
		 
		 Map<String,HashMap<String,String>> usrInformation = new HashMap<String,HashMap<String,String>>();


		public HashMap<String, String> getUsrDetails() {
			return UsrDetails;
		}
		//creating a HashMap which consists of user name and book details of that user
		public void setUserDetails(String usr) {
			if(usr.equalsIgnoreCase("Adam Sandler")) {
				UsrDetails.put("New Books:","Ulysses");
				UsrDetails.put("Favourite Books:","Don Quixote,One Hundred Years of Solitude");
				UsrDetails.put("Completed Books:","Hamlet");
			}
			else if(usr.equalsIgnoreCase("Tom Hanks")) {
				UsrDetails.put("New Books:","One Hundred Years of Solitude");
				UsrDetails.put("Favourite Books:","Don Quixote,One Hundred Years of Solitude");
				UsrDetails.put("Completed Books","Hamlet");
			}
			else if(usr.equalsIgnoreCase("Tom Cruise")) {
				UsrDetails.put("New Books:","Don Quixote");
				UsrDetails.put("Favourite Books:","Ulysses,Hamlet");
				UsrDetails.put("Completed Books:","In Search of Lost Time");
				
			}
			else if(usr.equalsIgnoreCase("Angelina Jolie")) {
				UsrDetails.put("New Books:","Ulysses,In Search of Lost Time");
				UsrDetails.put("Favourite Books:","Don Quixote");
				UsrDetails.put("Completed Books:","Don Quixote,Hamlet");
			}
			else if(usr.equalsIgnoreCase("Scarlett Johansson")) {
				UsrDetails.put("New Books:","In Search of Lost Time");
				UsrDetails.put("Favourite Books:","Ulysses");
				UsrDetails.put("Completed Books:","Hamlet");
			
			}
			usrInformation.put(usr,UsrDetails);
			
		}
		
}		 
		 
		 
		
		
		
		 
		

	


