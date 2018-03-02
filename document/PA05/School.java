package PA05;

import javax.swing.JOptionPane;

public class School {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course Course= new Course(JOptionPane.showInputDialog("enter course code"), JOptionPane.showInputDialog("enter a course"), 0);
		
		// 1 - prompt the user to provide the number of students, integer n value
		// 2 - Instantiates the course object
		// 3 - Prompt the user to input the student data, and calls addStudentGrade() to add the student to course, for n students
		// 4 - Prompt the user to input the grade data, and calls aaddStudentGradeToCourse() to add the grade to course, for n grades
		// 5 - Displays the course statistics by calling displayCourseStat()
	}
	
	// it uses the course object to add a new student to the course
	public static void addStudentToCourse(int id, String name){
		
	}
	
	// it uses the course object to add a new grade object to the course
	public static void addStudentGradeToCourse(int id, String assignment, Student student, double score){
			
	}
	
	// it should display the grade average and the highest student grade, student name 
	public void displayCourseStat(){
		
	}

}
