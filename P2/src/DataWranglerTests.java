//NAME: NAVYA MONGIA DATAWRANGLER TEAM BLUE
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.textui.*;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Assertions;
public class DataWranglerTests {
	
	//Test 1 to check whether the loader works or not and whather the student info at index 1 or list is correct or not
	
	@Test
	void test1() throws SAXException, ParserConfigurationException, IOException {
		StudentLoader s = new StudentLoader();
		List<IStudent> student_info_output = s.loadStudents("C:\\Users\\HP\\eclipse-workspace\\P2_DATAWRANGLER\\src\\students.xml");
		IStudent stu = new Student();
		stu.setName("Bernard Livingston");
		
		stu.setEmail("bernardlivingston@wisc.edu");
		stu.setGrade(3.5);
		stu.setID("541988808");
		stu.setMajor("Computer Science");
		Assertions.assertEquals(student_info_output.get(1).getName(), stu.getName() );
		Assertions.assertEquals(student_info_output.get(1).getEmail(), stu.getEmail() );
		Assertions.assertEquals(student_info_output.get(1).getGrade(), stu.getGrade() );
		Assertions.assertEquals(student_info_output.get(1).getID(), stu.getID() );
		Assertions.assertEquals(student_info_output.get(1).getMajor(), stu.getMajor() );
	}
	
	//test2 to check whether the newly inserted student info is correct or not and whether it is actually inserted in our xml 
	@Test
	void test2() throws SAXException, ParserConfigurationException, IOException
	{
		StudentSaver s = new StudentSaver();
		StudentLoader sl = new StudentLoader();
		IStudent stu = new Student();
		stu.setName("Navya");
		
		stu.setEmail("mongia@wisc.edu");
		stu.setGrade(4.0);
		stu.setID("2234567");
		stu.setMajor("comp sci");
		s.saveStudents("C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\P2_DATAWRANGLER\\\\src\\\\studentstemp.xml", stu);
		List<IStudent> student_info_output = sl.loadStudents("C:\\Users\\HP\\eclipse-workspace\\P2_DATAWRANGLER\\src\\studentstemp.xml");
		
		int index = student_info_output.size() - 1  ;
		Assertions.assertEquals(student_info_output.get(index).getName(), stu.getName() );
		Assertions.assertEquals(student_info_output.get(index).getEmail(), stu.getEmail() );
		Assertions.assertEquals(student_info_output.get(index).getGrade(), stu.getGrade() );
		Assertions.assertEquals(student_info_output.get(index).getID(), stu.getID() );
		Assertions.assertEquals(student_info_output.get(index).getMajor(), stu.getMajor() );
		
	}
	
	//test3 checks by giving a wrong xml file explicitly so that the test returns true if the file does not exist
	@Test 
	void test3()
	{
		boolean file_checker = true;
		
		StudentLoader sl = new StudentLoader();
		try {
			sl.loadStudents("wrongfilename.xml");
			file_checker = false;
			Assertions.assertEquals(file_checker , false);
		
		}
		catch(Exception e)
		{
			
		}
			
		
	}
	//test4 involves adding another student info and saving it in the xml file and it returns true if the info inserted is correct
	@Test
	void test4() throws SAXException, ParserConfigurationException, IOException
	{
		
		StudentSaver s = new StudentSaver();
		StudentLoader sl = new StudentLoader();
		IStudent stu = new Student();
		stu.setName("Jatin Mamtani");
		
		stu.setEmail("jm@wisc.edu");
		stu.setGrade(3.0);
		stu.setID("229987");
		stu.setMajor("computer science");
		
	
		
		
		s.saveStudents("C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\P2_DATAWRANGLER\\\\src\\\\studentstemp.xml", stu);
		List<IStudent> student_info_output = sl.loadStudents("C:\\Users\\HP\\eclipse-workspace\\P2_DATAWRANGLER\\src\\studentstemp.xml");
		int index = student_info_output.size() - 1 ;
		Assertions.assertEquals(student_info_output.get(index).getEmail(), stu.getEmail() );
		Assertions.assertEquals(student_info_output.get(index).getGrade(), stu.getGrade() );
		Assertions.assertEquals(student_info_output.get(index).getID(), stu.getID() );
		Assertions.assertEquals(student_info_output.get(index).getMajor(), stu.getMajor() );
		
		
	}
	//test5 will return true if the size of the list is not equal to 500(which is the original size)
    @Test
	void test5() throws SAXException, ParserConfigurationException, IOException {
		StudentLoader s = new StudentLoader();
		List<IStudent> student_info_output = s.loadStudents("C:\\Users\\HP\\eclipse-workspace\\P2_DATAWRANGLER\\src\\studentstemp.xml");
		Assertions.assertNotEquals(student_info_output.size() , 500);
	}
    
    /**
     * Test to check middle student info, whether they are loaded correctly or not
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    @Test
	void IntegrationTest1() throws SAXException, ParserConfigurationException, IOException
	{
	StudentLoader s = new StudentLoader();
		List<IStudent> student_info_output = s.loadStudents("C:\\Users\\HP\\eclipse-workspace\\P2_DATAWRANGLER\\src\\students.xml");
		IStudent stu = new Student();
		stu.setName("Brian Jenkins");
		
		stu.setEmail("brianjenkins@wisc.edu");
		stu.setGrade(3.4);
		stu.setID("778563200");
		stu.setMajor("Math");
		
		IStudent stu2 = new Student();
		stu2.setName("Duncan Buckley");
		stu2.setEmail("duncanbuckley@wisc.edu");
		stu2.setGrade(3.5);
		stu2.setID("240202320");
		stu2.setMajor("Computer Science");
		
		IStudent stu3 = new Student();
		stu3.setName("Hedda Sweet");
		stu3.setEmail("heddasweet@wisc.edu");
		stu3.setGrade(3.3);
		stu3.setID("591716389");
		stu3.setMajor("Computer Science");
		
		IStudent stu4 = new Student();
		stu4.setName("Brent James");
		stu4.setEmail("brentjames1342@wisc.edu");
		stu4.setGrade(2.6);
		stu4.setID("701151004");
		stu4.setMajor("Computer Science");
		
		Assertions.assertEquals(student_info_output.get(20).getName(), stu.getName() );
		Assertions.assertEquals(student_info_output.get(20).getEmail(), stu.getEmail() );
		Assertions.assertEquals(student_info_output.get(20).getGrade(), stu.getGrade() );
		Assertions.assertEquals(student_info_output.get(20).getID(), stu.getID() );
		Assertions.assertEquals(student_info_output.get(20).getMajor(), stu.getMajor() );
		Assertions.assertEquals(student_info_output.get(25).getName(), stu2.getName() );
		Assertions.assertEquals(student_info_output.get(25).getEmail(), stu2.getEmail() );
		Assertions.assertEquals(student_info_output.get(25).getGrade(), stu2.getGrade() );
		Assertions.assertEquals(student_info_output.get(25).getID(), stu2.getID() );
		Assertions.assertEquals(student_info_output.get(25).getMajor(), stu2.getMajor() );
		Assertions.assertEquals(student_info_output.get(30).getName(), stu3.getName() );
		Assertions.assertEquals(student_info_output.get(30).getEmail(), stu3.getEmail() );
		Assertions.assertEquals(student_info_output.get(30).getGrade(), stu3.getGrade() );
		Assertions.assertEquals(student_info_output.get(30).getID(), stu3.getID() );
		Assertions.assertEquals(student_info_output.get(30).getMajor(), stu3.getMajor() );
		Assertions.assertEquals(student_info_output.get(35).getName(), stu4.getName() );
		Assertions.assertEquals(student_info_output.get(35).getEmail(), stu4.getEmail() );
		Assertions.assertEquals(student_info_output.get(35).getGrade(), stu4.getGrade() );
		Assertions.assertEquals(student_info_output.get(35).getID(), stu4.getID() );
		Assertions.assertEquals(student_info_output.get(35).getMajor(), stu4.getMajor() );
		
		
		
		
		
	}
    /**
     * Test to check whether first 5 students are getting loaded correctly
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    
    @Test
	void IntegrationTest2() throws SAXException, ParserConfigurationException, IOException {
		StudentLoader s = new StudentLoader();
		List<IStudent> student_info_output = s.loadStudents("C:\\Users\\HP\\eclipse-workspace\\P2_DATAWRANGLER\\src\\students.xml");
		IStudent stu = new Student();
		stu.setName("Arsenio Martin");
		
		stu.setEmail("arseniomartin674@wisc.edu");
		stu.setGrade(3.3);
		stu.setID("335257369");
		stu.setMajor("Business");
		IStudent stu2 = new Student();
		stu2.setName("Fletcher Riley");
		
		stu2.setEmail("fletcherriley@wisc.edu");
		stu2.setGrade(3.1);
		stu2.setID("544867889");
		stu2.setMajor("Math");
		IStudent stu3 = new Student();
		stu3.setName("Adena Madden");
		
		stu3.setEmail("adenamadden8795@wisc.edu");
		stu3.setGrade(3.6);
		stu3.setID("886629236");
		stu3.setMajor("Business");
		IStudent stu4 = new Student();
		stu4.setName("Christine Thompson");
		
		stu4.setEmail("christinethompson3431@wisc.edu");
		stu4.setGrade(3.8);
		stu4.setID("608472607");
		stu4.setMajor("Business");
		IStudent stu5 = new Student();
		stu5.setName("Ima Wilkerson");
		
		stu5.setEmail("imawilkerson6017@wisc.edu");
		stu5.setGrade(3.5);
		stu5.setID("223192940");
		stu5.setMajor("Business");
		Assertions.assertEquals(student_info_output.get(2).getName(), stu.getName() );
		Assertions.assertEquals(student_info_output.get(2).getEmail(), stu.getEmail() );
		Assertions.assertEquals(student_info_output.get(2).getGrade(), stu.getGrade() );
		Assertions.assertEquals(student_info_output.get(2).getID(), stu.getID() );
		Assertions.assertEquals(student_info_output.get(2).getMajor(), stu.getMajor() );
		Assertions.assertEquals(student_info_output.get(3).getName(), stu2.getName() );
		Assertions.assertEquals(student_info_output.get(3).getEmail(), stu2.getEmail() );
		Assertions.assertEquals(student_info_output.get(3).getGrade(), stu2.getGrade() );
		Assertions.assertEquals(student_info_output.get(3).getID(), stu2.getID() );
		Assertions.assertEquals(student_info_output.get(3).getMajor(), stu2.getMajor() );
		Assertions.assertEquals(student_info_output.get(4).getName(), stu3.getName() );
		Assertions.assertEquals(student_info_output.get(4).getEmail(), stu3.getEmail() );
		Assertions.assertEquals(student_info_output.get(4).getGrade(), stu3.getGrade() );
		Assertions.assertEquals(student_info_output.get(4).getID(), stu3.getID() );
		Assertions.assertEquals(student_info_output.get(4).getMajor(), stu3.getMajor() );
		Assertions.assertEquals(student_info_output.get(5).getName(), stu4.getName() );
		Assertions.assertEquals(student_info_output.get(5).getEmail(), stu4.getEmail() );
		Assertions.assertEquals(student_info_output.get(5).getGrade(), stu4.getGrade() );
		Assertions.assertEquals(student_info_output.get(5).getID(), stu4.getID() );
		Assertions.assertEquals(student_info_output.get(5).getMajor(), stu4.getMajor() );
		Assertions.assertEquals(student_info_output.get(6).getName(), stu5.getName() );
		Assertions.assertEquals(student_info_output.get(6).getEmail(), stu5.getEmail() );
		Assertions.assertEquals(student_info_output.get(6).getGrade(), stu5.getGrade() );
		Assertions.assertEquals(student_info_output.get(6).getID(), stu5.getID() );
		Assertions.assertEquals(student_info_output.get(6).getMajor(), stu5.getMajor() );
	}
	/**
	 * Test to check the output if the user enters 5 , that is exit 
	 */
   @Test
    void CodeReviewOfFrontendDevelopertest1() {
    	
    	TextUITester t = new TextUITester("5\n");
    	GradeDatabaseFrontend f = new GradeDatabaseFrontend(new GradeDatabaseBackend());
		f.runApp();
       String output = t.checkOutput();
       Assertions.assertTrue(output.contains("Goodbye!"));
    	
    	
    }
   /**
    * To check the output , if the user enters 1 , that is calculating mean
    */
   
   @Test
   void CodeReviewOfFrontendDevelopertest2() {
   	
   	TextUITester t = new TextUITester("1\n5\n");
   	GradeDatabaseFrontend f = new GradeDatabaseFrontend(new GradeDatabaseBackend());
		f.runApp();
      String output = t.checkOutput();
      Assertions.assertTrue(output.contains("You are in the Mean Calculator:"));
      Assertions.assertTrue(output.contains("Mean of the Data:"));
      Assertions.assertTrue(output.contains("Exiting back to main menu"));
   	
   	
   }
    
   
	
	
		
	}
	

