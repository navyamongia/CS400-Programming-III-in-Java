/**
 * Name: Navya Mongia
 * FrontendDeveloper team blue DC
 * TA: Yelun Bao
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ShortestPathFrontend implements IShortestPathFrontend {
	  private Scanner inputScanner;
	  private IGraphBackend<String> backend;
	  private boolean running = true;
	  
	  public ShortestPathFrontend(Scanner inputScanner, IGraphBackend<String> backend) {
		    this.inputScanner = inputScanner;
		    this.backend = backend;
		  }
	 
	  /**
	   * Method to run the app
	   */
	  @Override
	public void runApp() { //method to run the app
		// TODO Auto-generated method stub
		
		while(running)
		{displayMainMenu();}
		
		
		
	}
	  /**
	   * Method to display the main menu options
	   */
	@Override
	public void displayMainMenu() { //method that displays the main menu which has all the options for user
		// TODO Auto-generated method stub
		 while (running){
	      System.out.print(
	          "Welcome to our GPS Tracker!\n"
	          + "\n"
	          + "\n"
	          +"You are in the Main Menu \n");
	          displayAllCities(); //calling this method, this method will display all the cities that are available for the user
//	          +"Cities available: \n"
//	          +"Chicago, Boston, Hawaii, Austin, New York, Los Angeles \n"
System.out.print(
				"\n"
	          + "Enter a number to use one of the following functions: \n"
	          + "     1) To find shortest distance between two cities. \n"
	          + "     2) Show all cities that are reachable within the input distance. \n"
	          + "     3)Exit \n"
	          + "\n");
	      String userinput = inputScanner.nextLine();
	      switch (userinput) { //switch case to check the userinput 
	        case "1":
	          displayShortestPath();
	          break;
	        case "2":
	          displayCitiesInRange();
	          break;
	        case "3":
	          running = false;
	          System.out.print("Thanks For Using Our Application!\n");
	          break;
	        default:
	          System.out.print("Invalid input, please try again!\n");
	          break;
	      }
	    }
		
	}

	
	/**
	 * Method to display all cities that are available for the user
	 */
	
	@Override
	public void displayAllCities() { //method that shows the available cities
		// TODO Auto-generated method stub
		ArrayList<String> b = backend.getAllCities(); //calling the method get all cities 
		System.out.print("Cities Available:\n");
		for(int i = 0 ; i < b.size()-1 ; i++) //loop to iterate through the array list
		{
			
			System.out.print(  b.get(i) + ",");
		}
		System.out.print(b.get(b.size() - 1 ));
	
	    
		
		
	}
 /**
 * Method to display the cities that are well within the range of user input
 */
	@Override
	public void displayCitiesInRange() { //this method displays output acc to the user input range of distance
		// TODO Auto-generated method stub
		System.out.print("Enter a starting city :"); //asking the user to enter the starting and the destination city 
		 String userinput1 = inputScanner.nextLine();
		 backend.changeStart(userinput1);
		 System.out.print("Enter a distance(miles) :");
		 String userinput2 = inputScanner.nextLine();
		 System.out.print("City that is reachable within " + userinput2 + " miles from " + userinput1 +" :");
		 ArrayList<String> b3= backend.getCitiesCloseBy(Integer.parseInt(userinput2)); //getting the cities wrt the user input
		 for(int i = 0; i<b3.size()-1 ; i++) //iterating through the list
		 {
			 System.out.print(b3.get(i) + ",");
		 }
			System.out.print(b3.get(b3.size() - 1 ));
		 System.out.print("\n");
		
	}
	
	/**
	 * Method to display shortest path between two cities 
	 * 
	 */

	@Override
	public void displayShortestPath() {
		// TODO Auto-generated method stub
		System.out.print("Enter Starting city: ");
		  String userinput1 = inputScanner.nextLine(); //asking user for input city
		backend.changeStart(userinput1);
		  
		   
		   
		   System.out.print("Enter Destination: ");
		   String userinput2 = inputScanner.nextLine(); //asking user for the destination city

		
			   ArrayList<String> b2 = backend.shortestPathToTake(userinput2); //getting the shortest path accordingly along with the cities on the shortest path
			   if(!backend.getAllCities().contains(userinput2) || !backend.getAllCities().contains(userinput1))
			   {
				   System.out.print("Invalid cities, please try again!\n");
				   //System.out.print("\n");
				   displayMainMenu();
				   return;
			   }
			   System.out.print("Cities on the shortest distance are: ");
			  
			   System.out.print(b2.get(0));
			   System.out.print("---->");
			   for(int i = 0 ; i <= b2.size() -3   ; i++)
			   {
				   System.out.print(b2.get(i+1) );
				   
				   System.out.print("---->" );
				   
			   }
			   System.out.print(b2.get(b2.size()-1));
			   System.out.print("\n");
			   System.out.print("The shortest distance between cities is :" + backend.shortestPathLength(userinput2) + " miles"); //displaying the shortest path
			   System.out.print("\n");
		
		    
	}
	public static void main(String[] args) {
	    ShortestPathFrontend frontend = new ShortestPathFrontend(new Scanner(System.in), new FDGraphBackendPlaceholder());
	    frontend.runApp();
	  }

	

}
