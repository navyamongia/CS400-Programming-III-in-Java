import java.util.List;

/**
 * Instances of this interface implement the data summary, add and search functionality
 * of the Grade Database app using the red black tree.
 */
public interface IGradeDatabaseBackend {

  /**
   * Adds a new student's details to the backend's database and is stored in
   * a RBT internally.
   *
   * @param student the students grade to add to the red black tree
   */
  public void addGrade(IStudent student);

  /**
   * Returns the number of students stored in the red black tree.
   *
   * @return the number of students
   */
  public int getNumberOfStudents();

  /**
   * Return the student uniquely identified by the student ID, or null if the student ID is not
   * present in the dataset.
   *
   * @param ID the student's ID number
   * @return the student identified by the ID, or null if ID is not in the database
   */
  public IStudent getByStudentID(String ID);

  /**
   * Returns the average gpa of the entire student body given in a semester
   *
   * @return the average gpa
   */
  public double getGradeMean();

  /**
   * Returns the median gpa of the entire student body given in a semester 
   *
   * @return the central or middle gpa
   */
  public double getGradeMedian();

/**
   * Returns the standard deviation of the entire student body given in a semester to describe
   * the distribution of grades
   *
   * @return the standard deviation
   */
  public double getGradeStandardDeviation();

  /**
   * Returns the distance between the smallest and largest GPA of the entire student body given
   * in a semester to describe the distribution of grades
   *
   * @return the grade range
   */
  public double getGradeRange();
}
