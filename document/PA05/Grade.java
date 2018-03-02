package PA05;

public class Grade {
	private int id;
	private String assignment;
	private Student student;
	private double score;
	private static int noOfGrades;
	
	public Grade() {
		this(0, null,null,0.0);
		// TODO Auto-generated constructor stub
	}

	// complete grade object constructor
	public Grade(int id, String assignment, Student student, double score) {
		this.id = id;
		this.assignment = assignment;
		this.student = student;
		this.score = score;
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

	public static void setNoOfGrades(int noOfGrades) {
		Grade.noOfGrades = noOfGrades;
	}
	
	
	// compete public getter and setter methods

}
