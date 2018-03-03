package com.fire.quiz5.PA05Fire;

import com.sun.codemodel.internal.JOp;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.JOptionPane;

public class School {
 static Course course;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 - prompt the user to provide the number of students, integer n value
		String number = JOptionPane.showInputDialog("how many student you input");
		while(!checkInt(number)){
			System.out.println("请输入整数");
			number = JOptionPane.showInputDialog("how many student you input");
		}
		int n = Integer.parseInt(number);
		// 2 - Instantiates the course object
		int courseId = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Course Id"));
		String description =  JOptionPane.showInputDialog(null,"Enter course description");
		course = new Course(courseId,description,n);
		for(int i=0;i<n;i++) {
			// 3 - Prompt the user to input the student data, and calls addStudentGrade() to add the student to course, for n students
			String name = JOptionPane.showInputDialog(null,"Enter your name");
			int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Student Id"));
			
			// 4 - Prompt the user to input the grade data, and calls aaddStudentGradeToCourse() to add the grade to course, for n grades
			double score = Double.parseDouble(JOptionPane.showInputDialog(null,"enter the score"));
			
			Student s1 = addStudentToCourse(id, name);
			addStudentGradeToCourse(courseId,description, null, score);
		}
		// 5 - Displays the course statistics by calling displayCourseStat()
		displayCourseStat();
	}
	// it uses the course object to add a new student to the course
	public static Student addStudentToCourse(int id, String name){
		Student s = course.addStudent(id, name);
		return s ;
	}
	
	// it uses the course object to add a new grade object to the course
	public static void addStudentGradeToCourse(int id, String assignment, Student student, double score){
			course.addGrade(id, assignment, student, score);
	}
	
	// it should display the grade average and the highest student grade, student name 
	public static void displayCourseStat(){
		String message = "Grade Average: " + course.getGradeAVG() + "\n" + course.getHiegestStudentGrade() ;
		JOptionPane.showMessageDialog(null, message);
		}


	private static Boolean checkInt(String number){
		try {
			Integer.parseInt(number);
		}catch (NumberFormatException e){
			return false;
		}
		return true;
	}

	private static Boolean checkDouble(String number){
		try {
			Double.parseDouble(number);
		}catch (NumberFormatException e){
			return false;
		}
		return true;
	}
}
