/**
 * This interface defines getter methods for each student's data attributes
 * and is implemented by classes that represent a student and its associated
 * data.
 */
public interface IStudent extends Comparable<IStudent>{
	void setID(String ID);
	
	void setGrade(double grade);
	
	void setEmail(String email);

	void setName(String name);
	
	void setMajor(String major);
    /**
     * Returns the name of the student.
     * @return name of the student
     */
    String getName();
    /**
     * Returns the email of the student.
     * @return email of the student
     */
    String getEmail();

    /**
     * Returns the ID of the student.
     * @return ID of the student
     */
    String getID();

    /**
     * Returns the grade of the student.
     * @return grade of the student
     */
    double getGrade();

    /**
     * Returns the major of the student.
     * @return major of the student
     */
    String getMajor();
    public int compareTo(IStudent stu);
}
