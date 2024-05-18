//CS400
//Name:Yousef Gadalla
//Email: ygadalla@wisc.edu
//TA: Yelun
//Lecturer Florian Heimerl
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.textui.*;

public class FrontendDeveloperTests {

  GradeDatabaseFrontend frontend;
  
 /* @BeforeEach
  public void setUp() {
	  frontend = new GradeDatabaseFrontend(new GradeDatabaseBackend());
  }*/
  
  /**
   * tester method that checks that pressing one allows for new Mean Calculator to be called
   * w/ expected output
   */
  @Test
  public void test1() {
    TextUITester tester = new TextUITester("1\n5\n");
    frontend = new GradeDatabaseFrontend(new GradeDatabaseBackend());
  
    frontend.runApp();
    String output = tester.checkOutput();
    
    assertEquals(output,"You are in the Mean Calculator:\n"
        +"   Mean of the Data: 1\n   Goodbye!");
  }
 /**
  *tester that checks that pressing 2 allows for Standard Deviation calculator
  */ 
  @Test
  public void test2() {
    TextUITester tester = new TextUITester("2\n5\n");
    frontend = new GradeDatabaseFrontend(new GradeDatabaseBackend());
  
   
    frontend.runApp();
    String output = tester.checkOutput();
    
    assertEquals(output, "You are in the Standard Deviation Calculator:\n"+
            "   Standard Deviation: 4.0");
    
  }
  
   /**
   *tester that checks that pressing 3 allows for student adder
   */
  @Test
  public void test3() {
          TextUITester tester =
                  new TextUITester("3\nIsaac\nemail@wisc\n2312\n3.4\nBusiness\n5\n");
          frontend = new GradeDatabaseFrontend(new GradeDatabaseBackend());
  

          frontend.runApp();
          String output = tester.checkOutput();

          assertEquals(output,"You are in the Adding Student program" +
                         "   Enter the Name of the student:" +
                        "   Enter the email:\n   Enter the Student ID:" +
                       "   Enter the GPA:\n   Enter Students Major:\n"+
                       "Student: Isaac has been added");
  }

  @Test
  public void test4() {
        TextUITester tester = new TextUITester("4\n2312\n5\n");
        frontend = new GradeDatabaseFrontend(new GradeDatabaseBackend());
  
        frontend.runApp();
        String output = tester.checkOutput();

        assertEquals(output, "You are in the Student Search: \n   Enter the ID of the "+
                        "student: \n   Student not found");
  }

 @Test
 public void test5(){
	TextUITester tester = new TextUITester("5\n");
	 frontend = new GradeDatabaseFrontend(new GradeDatabaseBackend());
 
	frontend.runApp();
       String output = tester.checkOutput();
	assertEquals(output, "Goodbye!");

	tester = new TextUITester("7\n5\n");
	frontend.runApp();
	output=tester.checkOutput();
	assertEquals(output,"Unrecognized input\n\nGoodbye!\n");	
 }
}
