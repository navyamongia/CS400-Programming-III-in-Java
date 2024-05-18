import java.io.FileNotFoundException;
import java.util.List;

/**
 * Instances of this interface can be used to save new student data into the xml file
 */
public interface IStudentSaver {

    /**
     * This method saves the student info into XML file
     * @param filepathToXML path to the XML file
     * @throws FileNotFoundException
     */

    void saveStudents(String filepathToXML,IStudent student) throws FileNotFoundException;
}