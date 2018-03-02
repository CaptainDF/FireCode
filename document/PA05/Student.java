package PA05;

public class Student {
	
	private int id;
	private String name;
	private static int noOfStudents;

	// complete student object constructor
	public Student() {
		this(0,null);	
	}

	public Student(int id, String name) {
		
		this.id = id;
		this.name = name;
		noOfStudents++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getNoOfStudents() {
		return noOfStudents;
	}

	
	}	
	// compete public getter and setter methods

