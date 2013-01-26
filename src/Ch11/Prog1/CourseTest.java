/**
 * Program: CourseTest.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 19, 2013
 * Purpose: To test the Course class.
 */

package Ch11.Prog1;

public class CourseTest {
	
	
	public static void main(String[] args){
		Course myCourse1 = new Course("Course 1");
		Course myCourse2 = new Course("Course 2");
		
		
		myCourse1.addStudent("Peter Jones");
		myCourse1.addStudent("Brian Smith");
		myCourse1.addStudent("Anne Kenedy");
		
		myCourse2.addStudent("Peter Jones");
		myCourse2.addStudent("Steve Smith");
		
		System.out.print("Number of students in ");
		myCourse1.getCourseName(0);
		
		for (int i = 0; i <= myCourse1.getNumberOfStudents(); i++){
			System.out.println(myCourse1.getStudents(i) + ",");
		}
		
		System.out.println();
		
		System.out.print("Number of students in ");
		myCourse2.getCourseName(0);
		
		for (int i = 0; i <= myCourse2.getNumberOfStudents(); i++){
			System.out.println(myCourse2.getStudents(i));
		}
	}

}
