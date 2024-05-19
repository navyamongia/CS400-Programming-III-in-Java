/*** JUnit imports ***/
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*** JUnit imports end  ***/


public class FrontendDeveloperTests {
	@SuppressWarnings("unused")
	private ShortestPathFrontend frontend;
	private TextUITester test;
	
// setting up frontend class to be tested
@BeforeEach	
 public void FT() {
	 FDGraphBackendPlaceholder backend=new FDGraphBackendPlaceholder();
	frontend=new ShortestPathFrontend(new Scanner(System.in),backend);
 }

  /**
   * Test1 to check that if user enters 3 it should exit as option 3 is exit
   */
	@Test
  public void test1() {
	test = new TextUITester("3\n");

	TextUITester.run();
  String expected = "Welcome to our GPS Tracker!\n" 
+"\n"
+"\n"
+"You are in the Main Menu \n" 
+"Cities Available:\n"
+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
+"Enter a number to use one of the following functions: \n"
+"     1) To find shortest distance between two cities. \n"
+"     2) Show all cities that are reachable within the input distance. \n" 
+"     3)Exit \n"
+ "\n"
+"Thanks For Using Our Application!\n" ;
   
 String output = test.checkOutput();
 Assertions.assertEquals(expected, output);
  }
	/**
	 * Test2 to check that if user enters option 1 and then inputs 2 cities it will display the shortest distance between them
	 */
	@Test
	  public void test2() {
		test = new TextUITester("1\nNew York\nLos Angeles\n3\n");

		TextUITester.run();
	  String expected = "Welcome to our GPS Tracker!\n" 
	+"\n"
	+"\n"
	+"You are in the Main Menu \n" 
	+"Cities Available:\n"
	+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
	+"Enter a number to use one of the following functions: \n"
	+"     1) To find shortest distance between two cities. \n"
	+"     2) Show all cities that are reachable within the input distance. \n" 
	+"     3)Exit \n"
	+ "\n"
	+"Enter Starting city: " 
	+"Enter Destination: "
	+"Cities on the shortest distance are: New York---->Chicago---->Las Vegas---->Los Angeles\n"
	+"The shortest distance between cities is :2797.2 miles\n"
	+"Welcome to our GPS Tracker!\n" 
	+"\n"
	+"\n"
	+"You are in the Main Menu \n" 
	+"Cities Available:\n"
	+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
	+"Enter a number to use one of the following functions: \n"
	+"     1) To find shortest distance between two cities. \n"
	+"     2) Show all cities that are reachable within the input distance. \n" 
	+"     3)Exit \n"
	+ "\n"
	+"Thanks For Using Our Application!\n";
	
	 String output = test.checkOutput();
	Assertions.assertEquals(expected, output);
	  }

	/**
	 * Test3 to check that if user enters an invalid input option like 4
	 */
	
	@Test
	  public void test3() {
		test = new TextUITester("4\n3\n");

		TextUITester.run();
	  String expected = "Welcome to our GPS Tracker!\n" 
				+"\n"
				+"\n"
				+"You are in the Main Menu \n" 
				+"Cities Available:\n"
				+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
				+"Enter a number to use one of the following functions: \n"
				+"     1) To find shortest distance between two cities. \n"
				+"     2) Show all cities that are reachable within the input distance. \n" 
				+"     3)Exit \n"
				+ "\n"
 
+"Invalid input, please try again!\n"
+"Welcome to our GPS Tracker!\n" 
	+"\n"
	+"\n"
	+"You are in the Main Menu \n" 
	+"Cities Available:\n"
	+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
	+"Enter a number to use one of the following functions: \n"
	+"     1) To find shortest distance between two cities. \n"
	+"     2) Show all cities that are reachable within the input distance. \n" 
	+"     3)Exit \n"
	+ "\n"
	+"Thanks For Using Our Application!\n" ;
	   
	 String output = test.checkOutput();
	 Assertions.assertEquals(expected, output);
	  }


	/**
	 * Test4 to check that if user enters option 2 then it should ask for input and display cities accordingly
	 */
	@Test
	  public void test4() {
		test = new TextUITester("2\nMilwaukee\n1000\n3\n");

		TextUITester.run();
	  String expected = "Welcome to our GPS Tracker!\n" 
	+"\n"
	+"\n"
	+"You are in the Main Menu \n" 
	+"Cities Available:\n"
	+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
	+"Enter a number to use one of the following functions: \n"
	+"     1) To find shortest distance between two cities. \n"
	+"     2) Show all cities that are reachable within the input distance. \n" 
	+"     3)Exit \n"
	+ "\n"
	+"Enter a starting city :" 
	+"Enter a distance(miles) :"
	+"City that is reachable within 1000 miles from Milwaukee :Chicago,Boston\n"
	+"Welcome to our GPS Tracker!\n" 
	+"\n"
	+"\n"
	+"You are in the Main Menu \n" 
	+"Cities Available:\n"
	+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
	+"Enter a number to use one of the following functions: \n"
	+"     1) To find shortest distance between two cities. \n"
	+"     2) Show all cities that are reachable within the input distance. \n" 
	+"     3)Exit \n"
	+ "\n"
	+"Thanks For Using Our Application!\n";
	
	 String output = test.checkOutput();
	Assertions.assertEquals(expected, output);
	  }
	

	/**
	 * If user enters presses 2 enterkeys and then exits
	 */
	@Test
	  public void test5() {
		test = new TextUITester("\n\n3\n");

		TextUITester.run();
	  String expected = "Welcome to our GPS Tracker!\n" 
				+"\n"
				+"\n"
				+"You are in the Main Menu \n" 
				+"Cities Available:\n"
				+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
				+"Enter a number to use one of the following functions: \n"
				+"     1) To find shortest distance between two cities. \n"
				+"     2) Show all cities that are reachable within the input distance. \n" 
				+"     3)Exit \n"
				+ "\n"
 
+"Invalid input, please try again!\n"
+"Welcome to our GPS Tracker!\n" 
+"\n"
+"\n"
+"You are in the Main Menu \n" 
+"Cities Available:\n"
+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
+"Enter a number to use one of the following functions: \n"
+"     1) To find shortest distance between two cities. \n"
+"     2) Show all cities that are reachable within the input distance. \n" 
+"     3)Exit \n"
+ "\n"

+"Invalid input, please try again!\n"
+"Welcome to our GPS Tracker!\n" 
	+"\n"
	+"\n"
	+"You are in the Main Menu \n" 
	+"Cities Available:\n"
	+"New York,Chicago,Boston,Austin,Hawaii,Los Angeles\n"
	+"Enter a number to use one of the following functions: \n"
	+"     1) To find shortest distance between two cities. \n"
	+"     2) Show all cities that are reachable within the input distance. \n" 
	+"     3)Exit \n"
	+ "\n"
	+"Thanks For Using Our Application!\n" ;
	   
	 String output = test.checkOutput();
	 Assertions.assertEquals(expected, output);
	  }
	
	
	@Test
	public void IntegrationTest1()
	{
		GraphBackend b = new GraphBackend("NewYork");
		 Scanner inputScanner = new Scanner("1\nNewYork\nChicago\n3\n");
		 TextUITester test = new TextUITester("1\nNewYork\nChicago\n3\n");
		    ShortestPathFrontend frontend = new ShortestPathFrontend(inputScanner, b);
		    frontend.runApp();
		    String output = test.checkOutput();
		    String expected = "Welcome to our GPS Tracker!\n" 
		    		+"\n"
		    		+"\n"
		    		+"You are in the Main Menu \n" 
		    		+"Cities Available:\n"
		    		+"SanFrancisco,Boston,hawaii,Miami,Austin,NewYork,Toronto,Charolette,LosAngeles,Chicago\n"
		    		+"Enter a number to use one of the following functions: \n"
		    		+"     1) To find shortest distance between two cities. \n"
		    		+"     2) Show all cities that are reachable within the input distance. \n" 
		    		+"     3)Exit \n"
		    		+ "\n"
		    		+"Enter Starting city: " 
		    		+"Enter Destination: "
		    		+"Cities on the shortest distance are: NewYork---->Chicago\n"
		    		+"The shortest distance between cities is :790.0 miles\n"
		    		+"Welcome to our GPS Tracker!\n" 
		    		+"\n"
		    		+"\n"
		    		+"You are in the Main Menu \n" 
		    		+"Cities Available:\n"
		    		+"SanFrancisco,Boston,hawaii,Miami,Austin,NewYork,Toronto,Charolette,LosAngeles,Chicago\n"
		    		+"Enter a number to use one of the following functions: \n"
		    		+"     1) To find shortest distance between two cities. \n"
		    		+"     2) Show all cities that are reachable within the input distance. \n" 
		    		+"     3)Exit \n"
		    		+ "\n"
		    		+"Thanks For Using Our Application!\n";
		    		
		    		
		    		Assertions.assertEquals(expected, output);
	}
	
	
	 @Test
     public void IntegrationTest2()
     {
             GraphBackend b = new GraphBackend("India");
              Scanner inputScanner = new Scanner("1\nIndia\nThailand\n3\n");
              TextUITester test = new TextUITester("1\nIndia\nThailand\n3\n");
                 ShortestPathFrontend frontend = new ShortestPathFrontend(inputScanner, b);
                 frontend.runApp();
                 String output = test.checkOutput();
                 String expected = "Welcome to our GPS Tracker!\n" 
     		    		+"\n"
    		    		+"\n"
    		    		+"You are in the Main Menu \n" 
    		    		+"Cities Available:\n"
    		    		+"SanFrancisco,Boston,hawaii,Miami,Austin,NewYork,Toronto,Charolette,LosAngeles,Chicago\n"
    		    		+"Enter a number to use one of the following functions: \n"
    		    		+"     1) To find shortest distance between two cities. \n"
    		    		+"     2) Show all cities that are reachable within the input distance. \n" 
    		    		+"     3)Exit \n"
    		    		+ "\n"
    		    		+"Enter Starting city: " 
    		    		+"Enter Destination: "
    		    		
    		    		+"Invalid cities, please try again!\n"
    		    		+"Welcome to our GPS Tracker!\n" 
    		    		+"\n"
    		    		+"\n"
    		    		+"You are in the Main Menu \n" 
    		    		+"Cities Available:\n"
    		    		+"SanFrancisco,Boston,hawaii,Miami,Austin,NewYork,Toronto,Charolette,LosAngeles,Chicago\n"
    		    		+"Enter a number to use one of the following functions: \n"
    		    		+"     1) To find shortest distance between two cities. \n"
    		    		+"     2) Show all cities that are reachable within the input distance. \n" 
    		    		+"     3)Exit \n"
    		    		+ "\n"
    		    		+"Thanks For Using Our Application!\n";



                             Assertions.assertEquals(expected, output);
     }
	
	
	
  
  

}
