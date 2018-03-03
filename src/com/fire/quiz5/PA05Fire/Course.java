package com.fire.quiz5.PA05Fire;

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
		students = new Student[n];
		grades = new Grade[n];
		// you should initialize the students and grades arrays here
		// these array should be of size n 
	}

	// Creates and adds a student object to the  students array
	public Student addStudent(int id, String name){
		Student student = new Student(id,name);
		students[Student.getNoOfStudents()-1] = student;
		return student;
	}

	// adds a grade object to the grades array
   public void addGrade(int id, String assignment, Student student, double score){
	  grades[Grade.getNoOfGrades()]= new Grade(id,assignment,student, score);
	}
   public double getGradeAVG(){
	   double sum = 0;
	   for(int i = 0; i < grades.length; i++) {
		   sum += grades[i].getScore();
	   }
	   return sum/grades.length;
	}
  
   
  public String getHiegestStudentGrade(){
	  	double highestGrade = 0;
	  	int Highest = 1;
	  	for(int i=0;i< grades.length;i++) {
	  		if (highestGrade< grades[i].getScore()) {
	  			highestGrade = grades[i].getScore();
	  			Highest= i;
	  		}
	  	}   	  	
	  	return "Name of highest Score:  "+ nameOfHighest(Highest)+"High score is " + highestGrade;		
	}
  	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	  public String nameOfHighest(int Highest) {
		  return students[Highest].getName();  
	  }

  
}

