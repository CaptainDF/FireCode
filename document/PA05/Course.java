package PA05;

public class Course {
	
	private int id;
	private String description;
	private Student[] students;
	private Grade[] grades;
	
	public Course() {
		this(0,null,0);
		// TODO Auto-generated constructor stub
	}

	// complete course object constructor
	public Course (int id, String description, int n){
		this.id = id;
		this.description = description;
		this.students = students;
		this.grades = grades;
		// you should initialize the students and grades arrays here
		// these array should be of size n 
	}

	// Creates and adds a student object to the  students array
	public void addStudent(int id, String name){
		
	}

	// adds a grade object to the grades array
   public void addGrade(){
		
	}
   
   
   
   public double getGradeAVG(){
	return 0;

		
	}
   
   
  public String getHiegestStudentGrade(){

	   
	   return "";
		
	}
   
   
}
