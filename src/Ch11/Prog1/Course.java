/**
 * Program: Course.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 19, 2013
 * Purpose: (The Course class) Rewrite the Course class in Listing 10.6. Use an ArrayList
 * to replace an array to store students. You should not change the original contract of
 * the Course class (i.e., the definition of the constructors and methods should not
 * be changed).
 */

package Ch11.Prog1;

import java.util.ArrayList;

public class Course {
	private ArrayList<String> courseName = new ArrayList<String>();
	private ArrayList<String> students = new ArrayList<String>();

	public Course(){	
	}
	
	public Course(String myCourseName) {
		courseName.add(myCourseName);
	}

	public void addStudent(String student) {
		students.add(student);
	}

	public String getStudents(int num) {
		return students.get(num);
	}

	public int getNumberOfStudents() {
		return students.size()-1;
	}

	public void CourseName(String newCourseName) {
		courseName.add(newCourseName);
	}
	
	public void getCourseName(int num) {
		System.out.println(courseName.get(num));
	}

	public void dropStudent(String student) {
		students.remove(student);
	}
}
