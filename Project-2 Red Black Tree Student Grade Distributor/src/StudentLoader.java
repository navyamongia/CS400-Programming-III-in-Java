//NAME : NAVYA MONGIA , DATAWRANGLER TEAM BLUE 

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentLoader implements IStudentLoader {

	public  List<IStudent> loadStudents(String filepathtoxml) throws SAXException ,ParserConfigurationException,IOException  {
		// TODO Auto-generated method stub
		
		List<IStudent> student_info_output = new ArrayList<IStudent>(); //creating a list to store all the parsed student info 
		IStudent student = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //first creating the document builder
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
		
				Document document = builder.parse(new File (filepathtoxml)); //getting the document that we want to parse
				document.getDocumentElement().normalize(); //normalising the xml structure 
				NodeList students_list = document.getElementsByTagName("student");
				for(int i = 0; i< students_list.getLength() ; i++) //to iterate through each and every student info
				{
					Node student_node = students_list.item(i);  //to get a particular student
					if(student_node.getNodeType() == Node.ELEMENT_NODE)
					{
						Element student_element = (Element)student_node;
						
						student = new Student();
						
					student.setName(student_element.getElementsByTagName("name").item(0).getTextContent() ); //to iterate through each tag inside the student tag
						student.setEmail(student_element.getElementsByTagName("email").item(0).getTextContent());
						student.setID(student_element.getElementsByTagName("ID").item(0).getTextContent());
						String student_grade_str = student_element.getElementsByTagName("grade").item(0).getTextContent();
						double student_grade = Double.parseDouble(student_grade_str);
						//double student_grade_dou = (double) student_grade;
						student.setGrade(student_grade);
						student.setMajor(student_element.getElementsByTagName("major").item(0).getTextContent());
						
						student_info_output.add(student); //to add the student info inside the list
						
					}
					
				}
				
				
				
		     }
		
			 catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student_info_output; //returning that list
		
	

}
}
	
	/*public static void main(String args[]) throws SAXException, ParserConfigurationException, IOException
	{
		StudentLoader s = new StudentLoader();
		List<IStudent> student_info_output = s.loadStudents("C:\\Users\\HP\\eclipse-workspace\\P2_DATAWRANGLER\\src\\students.xml");
		System.out.println(student_info_output);
		
		for(IStudent stu:student_info_output)
		{
			
		System.out.println( "student_name : " + stu.getName());
		System.out.println("student_email : " + stu.getEmail());
			
		System.out.println("student_ID : " + stu.getID());
		System.out.println("student_grade: " + stu.getGrade());
		System.out.println("student_major: " + stu.getMajor());
		System.out.println( "  ");
		
		}
		if(student_info_output.size() == 500)
		{
			System.out.println("yes");
		}*/


		
			
		
			
		
	
		
	//}
	

