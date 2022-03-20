/* InClass Assignment 415
 * Team Members: Sneha Simkhda, Tyler Daspit, Garrett Crawford
 */
public class Student {
	private String first ;
	private String last ;
	private int StudentId;
	private String major;
	private double GPA;
	
	public Student() {

	}
	
	public Student(String first, String last, String major, double GPA) {
		super();
		this.first = first;
		this.last = last;
		this.major = major;
		this.GPA = GPA;
	}
	
	public String getfirst() {
		return first;
		}
	
	public void setfirst(String first) {
		this.first = first;
		
	}
	
	public String getlast() {
		return last;
		}
	
	public void setlast(String last){
		this.last = last;
	}
	
	public int getStudentId() {
		return StudentId;
		}
	public void setStudentId(int StudentId) {
		this.StudentId = StudentId;
		}
	
	public String getmajor() {
		return major;
		}
	
	public void setmajor(String major) {
		this.major = major;
	}
	
	
	
	public double getGPA() {
		return GPA;
		}
	
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	

	public boolean StudentIdIsPrime() {
		for (int i = 2; i <= StudentId; i++) 
			if(StudentId % i == 0) 
				return true;
			return false;
			}
		
	
	}
	

