//NAME : NAVYA MONGIA , DATAWRANGLER TEAM BLUE 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;   //using dom parsers 
import org.w3c.dom.Element;


public class StudentSaver implements IStudentSaver {

	@Override
	public void saveStudents(String filepathToXML, IStudent student) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try {
		File inputFile = new File(filepathToXML); //the file that i want to insert values to 
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder(); //building the document
        Document doc = docBuilder.parse(inputFile); //to parse through the exisiting xml file
        Element rootele = doc.getDocumentElement(); //to get the root node/element
        System.out.println(rootele);
       
        IStudent stu = new Student() ;
      
        Element student1 = doc.createElement("student"); //to insert the student element inside students elements
        rootele.appendChild(student1);
        Element name1 = doc.createElement("name");
        name1.appendChild(doc.createTextNode(student.getName())); //to insert name of a student
        student1.appendChild(name1);
        
        Element email1 = doc.createElement("email");
        email1.appendChild(doc.createTextNode(student.getEmail())); //to insert email of a student
        student1.appendChild(email1);
        Element ID1 = doc.createElement("ID");
        ID1.appendChild(doc.createTextNode(student.getID())); //to insert ID
        student1.appendChild(ID1);
       // ID1.setText();
        Element grade1 = doc.createElement("grade");
        grade1.appendChild(doc.createTextNode(String.valueOf(student.getGrade()))); //to insert grade
        student1.appendChild(grade1);
        Element major1 = doc.createElement("major");
        major1.appendChild(doc.createTextNode(student.getMajor()));
        student1.appendChild(major1);
        TransformerFactory transformerFactory = TransformerFactory.newInstance(); //to write the results back to the xml file 
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\P2_DATAWRANGLER\\\\src\\\\studentstemp.xml"));
        transformer.transform(source, result);
        
        
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
	/*public static void main(String args[]) throws FileNotFoundException
	{
		StudentSaver s = new StudentSaver();
		IStudent stu = new Student();
		stu.setName("Navya");
		
		stu.setEmail("mongia@wisc.edu");
		stu.setGrade(4.0);
		stu.setID("2234567");
		stu.setMajor("comp sci");
		s.saveStudents("C:\\\\Users\\\\HP\\\\eclipse-workspace\\\\P2_DATAWRANGLER\\\\src\\\\students.xml", stu);
		
		
	}*/


