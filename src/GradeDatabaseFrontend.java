// --== CS400 Fall 2022 File Header Information ==--
// Name: Yousef Gadalla
// Email: ygadalla@wisc.edu
// Team: DC
// TA: Yelun
// Lecturer: Florian Heimrl


import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * class the operates as the user interface for the GradeDatabase App
 * 
 */
public class GradeDatabaseFrontend implements IGradeDatabaseFrontend {

  IGradeDatabaseBackend backend;

  /**
   * constructor that creates a GradeDatabaseFrontend object
   * @param backend that will be used to call on backend methods
   */
  public GradeDatabaseFrontend(IGradeDatabaseBackend backend) {
    //initializes backend
    this.backend = backend;
  }

  //creates scanner for GradeDatabase
  Scanner scn = new Scanner(System.in);

  /**
   * method that runs the app
   */
  public void runApp() {
    System.out.println("Welcome to the Grade Database!");
    displayMainMenu();
    System.out.println("Goodbye!");
  }

  
  /**
   * method that creates the user interface of the app
   */
  public void displayMainMenu() {
    
    //displays options for user
    System.out.println("\n");
    System.out.println(
        "You are in the Main Menu\n" + "Enter a number to use one of the following functions:");
    System.out.println("   1)Calculate Mean\n" + "   2)Calculate Standard Deviation\n"
        + "   3)Add Student\n" + "   4)Student Search\n" + "   5)Exit");
    String input = scn.nextLine();
    //scn.nextLine();
    //compares input with available options
    
    input = input.trim();
    if (input.equals("1")) {
      getMean();
    } else if (input.equals("2")) {
      getSD();
    } else if (input.equals("3")) {
      studentAdder();
    } else if (input.equals("4")) {
      searchStudent();
    } else if (input.equals("5")) {
      return;
    } else {
      //invalid input and user must try again
      System.out.println("Unrecognized input\n");
      displayMainMenu();
    }
  }

  /**
   * method that allows for the user to add a student to the gradeDatabase
   */
  public void studentAdder() {
    System.out.println("You are in the Adding Student program");
    
    //creates student
    Student student = new Student();
    
    //Get+Set name of student
    System.out.print("   Enter the Name of the student:");
    String name = scn.nextLine();
    student.setName(name);
    
    //Get +set email
    System.out.print("\n   Enter the email:");
    String email = scn.nextLine();
    student.setEmail(email);
    
    //get + set id
    System.out.print("\n   Enter the Student ID:");
    String id = scn.nextLine();
    student.setID(id);
    
    //set gpa
    Double grade = null;
    //while loop to ensure correctly added
    while (grade == null) {
      System.out.print("\n   Enter GPA:");
      String GPA = scn.nextLine();
      
      //try catch for parsing to double
      try {
        GPA = GPA.trim();
        grade = Double.parseDouble(GPA);
        student.setGrade(grade);
      } catch (NumberFormatException e) {
        grade =null;
        System.out.println("Invalid grade input. Try again");
      }
    } 
    
    //get and set for major
    System.out.print("\n   Enter Students Major:");
    String major = scn.nextLine();
    student.setMajor(major);

    
    
    //adds student
    backend.addGrade(student);
    System.out.println("Student " + student.getName() + " has been added with a grade of " + student.getGrade());

    System.out.println("Exiting back to main menu\n\n");
    displayMainMenu();
  }
	  /**
   * method that allows user to see the mean of the data
   */
  public void getMean() {

    // implement the call to getMean()
    double mean = backend.getGradeMean();
    System.out.println("You are in the Mean Calculator:");
    System.out.println("   Mean of the Data: " + mean);
    System.out.println("Exiting back to main menu\n\n");
    displayMainMenu();
  }

  /**
   * method that allows user to see the standard deviation of the data
   */
  public void getSD() {

    // implement the call to getSD();
    double sd = backend.getGradeStandardDeviation();
    System.out.println("You are in the Standard Deviation Calculator:");
    System.out.println("   Standard Deviation: " + sd);
    System.out.println("Exiting back to main menu\n\n");
    displayMainMenu();
  }

  /**
   * method that allows uer to search for student based on inputed ID
   */
  public void searchStudent() {

    System.out.println("You are in the Student Search: ");
    System.out.println("   Enter the ID of the student: ");
    String id = scn.nextLine();

    // implement the call to search for student();
    IStudent searched = backend.getByStudentID(id);
    
    //checks if student found
    if (searched == null) {
      System.out.println("   Student not found");
    } else {
      //runs if student found
      System.out.println("The student was found. " + searched.getName() + " received a score of "
          + searched.getGrade());
    }
    
    System.out.println("Exiting back to main menu\n\n");
    displayMainMenu();
  }

	
}
