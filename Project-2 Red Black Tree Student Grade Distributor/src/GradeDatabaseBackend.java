// --== CS400 Fall 2022 File Header Information ==--
// Name: Rea Mammen
// Email: rmammen@wisc.edu
// Team: DC
// TA: Yelun Bao
// Lecturer: Professor Florian
// Notes to Grader: NA
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.Iterator;
/*
 * Backend class that implements the functionality of the backend interface to perform statistical computations.
 */
public class GradeDatabaseBackend implements IGradeDatabaseBackend {
	private IterableTreeADT<IStudent> redBlackTree;
	private DescriptiveStatistics descriptiveStatistics;

	public GradeDatabaseBackend() {
		redBlackTree = new IterableRedBlackTree<>();
		descriptiveStatistics = new DescriptiveStatistics();
	}

	@Override
	public void addGrade(IStudent student) {
		redBlackTree.insert(student);
		descriptiveStatistics.addValue(student.getGrade());
	}

	@Override
	public int getNumberOfStudents() {
		return redBlackTree.size();
	}

	@Override
	public IStudent getByStudentID(String ID) {
		Iterator<IStudent> rbtIterator = redBlackTree.iterator();
		while(rbtIterator.hasNext()){
			IStudent student = rbtIterator.next();
			if(student.getID().equals(ID))
				return student;
		}
		return null;
	}

	@Override
	public double getGradeMean() {
		return descriptiveStatistics.getMean();
	}

	@Override
	public double getGradeMedian() {
		return descriptiveStatistics.getPercentile(50);
	}

	@Override
	public double getGradeStandardDeviation() {
		return descriptiveStatistics.getStandardDeviation();
	}

	@Override
	public double getGradeRange() {
		return descriptiveStatistics.getMax() - descriptiveStatistics.getMin();
	}

}
