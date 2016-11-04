package studentdb2;

import java.io.Serializable;

public class Student implements Serializable{
	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
        private String crushName;
        private Course favSubj;
	
	public Student(){}
	
	public Student(String studentNumber, String firstName, char middleInitial, String lastName, 
                       String course, int yearLevel, String crushName, Course favSubj) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.course = course;
		this.yearLevel = yearLevel;
                this.crushName = crushName;
                this.favSubj = favSubj;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}

	public char getMiddleInitial() {
		return middleInitial;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	public int getYearLevel() {
		return yearLevel;
	}
        
        public String getCrushName() {
            return crushName;
        }

        public void setCrushName(String crushName) {
            this.crushName = crushName;
        }

        public String getFavSubjCode() {
            return favSubj.getCode();
        }
        public String getFavSubjDesc() {
            return favSubj.getDesc();
        }

        public void setFavSubj(Course favSubj) {
            this.favSubj = favSubj;
        }
        
	
	public String toString() {
		String middle;
		if (middleInitial == (char)54321) { middle = "";}
		else {middle = String.valueOf(middleInitial);}
		return String.format("%s\n%s, %s %s\n%s\n%d\n%s\n%s\n", studentNumber, lastName, firstName, middle, course, yearLevel,crushName,favSubj);
	}
	
}