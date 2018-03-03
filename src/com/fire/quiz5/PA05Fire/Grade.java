package com.fire.quiz5.PA05Fire;

public class Grade {
	private int id;
	private String assignment;
	private Student student;
	private double score;
	private static int noOfGrades;
	
	public Grade() {
		this(0, "",null,0.0);
		// TODO Auto-generated constructor stub
	}

	// complete grade object constructor
	public Grade(int id, String assignment, Student student, double score) {
		this.id = id;
		this.assignment = assignment;
		this.student = student;
		this.score = score;
		noOfGrades++;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public static int getNoOfGrades() {
		return noOfGrades;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	
	// compete public getter and setter methods
     
}
