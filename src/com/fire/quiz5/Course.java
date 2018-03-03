package com.fire.quiz5;

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
		this.students = new Student[n];
		this.grades = new Grade[n];
		// you should initialize the students and grades arrays here
		// these array should be of size n 
	}

	// Creates and adds a student object to the  students array
	public void addStudent(int id, String name){
		this.students[id]=new Student(id,name);
	}

	// adds a grade object to the grades array
   public void addGrade(int id,String assignment,Student student, double score){
		this.grades[id] = new Grade(id,assignment,student,score);
	}
   
   
   
   public double getGradeAVG(){

   		double sum = 0.0F;

	   for (int i = 0; i < this.grades.length; i++) {
		   sum+=this.grades[i].getScore();
	   }
		return sum/this.grades.length;
	}
   
   
  public String getHiegestStudentGrade(){

   	double highScore=0;
	String name = "";
	  for (int i = 0; i < this.grades.length; i++) {
		  if (grades[i].getScore()>highScore){
		  	highScore=grades[i].getScore();
		  	name = this.students[i].getName();
		  }
	  }

	   return name+"---"+highScore;
		
	}
   
   
}
