
public class Student implements IStudent  {
private String name;
private String email;
private String ID;
private double grade;
private String major;

/*public Student(String name, String email, String ID, double grade, String major)
{
	this.name = name;
	this.email = email;
	this.ID = ID;
	this.grade = grade;
	this.major = major;
}*/


	@Override
	public void setID(String id) {
		// TODO Auto-generated method stub
		this.ID = id;
		
	}

	@Override
	public void setGrade(double g) {
		// TODO Auto-generated method stub
		this.grade = g;
		
	}

	@Override
	public void setEmail(String e) {
		// TODO Auto-generated method stub
		this.email = e;
		
	}

	@Override
	public void setName(String n) {
		// TODO Auto-generated method stub
		this.name = n;
		
	}
	@Override
	public void setMajor(String m) {
		// TODO Auto-generated method stub
		this.major = m;
		
	}

	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

	@Override
	public double getGrade() {
		// TODO Auto-generated method stub
		return this.grade;
	}

	@Override
	public String getMajor() {
		// TODO Auto-generated method stub
		return this.major;
	}

	@Override
	public int compareTo(IStudent stu) {
		// TODO Auto-generated method stub
		return this.ID.compareTo(stu.getID());
	}

	

	 
	

	
	

}
