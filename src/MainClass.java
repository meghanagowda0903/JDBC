import com.ripple.movies.controller.MovieMenuController;
import java.util.Scanner;
public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MovieMenuController movieMenuController=new MovieMenuController(sc);
		
		while(true) {
			 System.out.println("Movie Management System");
	            System.out.println("1. Add a Movie");
	            System.out.println("2. Update a Movie");
	            System.out.println("3. Delete a Movie");
	            System.out.println("4. Display All Movies");
	            System.out.println("5. Get a Movie by Id");
	            System.out.println("6. Exit");

	            int choice = sc.nextInt();
	            sc.nextLine();
	            
	            if(choice==6) {
	            	 System.out.println("Are you sure you want to exit? (Enter 'yes' to confirm, 'no' to continue)");
	                 String confirmExit = sc.nextLine();
	                 if (confirmExit.equalsIgnoreCase("yes")) {
	                     sc.close();
	                     System.out.println("Closed...."); 
	                     return;
	                 } 
	                 else if(confirmExit.equalsIgnoreCase("no")) {
	                	 continue;
	                 }
	            }
	            movieMenuController.handleMenuChoice(choice);
		}
	}

}
