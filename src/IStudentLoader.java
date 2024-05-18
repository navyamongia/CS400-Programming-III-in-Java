

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * Instances of this interface can be used to load student data from the xml file
 */
public interface IStudentLoader {
   
    /**
     * This method loads the student info from XML file
     * @param filepathToXML path to the XML file
     * @return a list of student objects
     * @throws FileNotFoundException
     */

    List<IStudent> loadStudents(String filepathtoxml) throws SAXException ,ParserConfigurationException,IOException;

}
