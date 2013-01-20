/*
 * Program: Chapter11Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 17, 2013
 * Purpose: This program will request the size of the sides of the triangle and determine the area and perimeter
 * it will also ask if the user wants a fill color. If no fill is designated it will display that the 
 * triangle will not be solid.
 */

package Ch11.Lab1;

import java.util.Scanner;

public class Chapter11Lab1 {
	
	public static void main(String[] args){
		//declare the variable, Scanner object and set repeat to yes
		Scanner input = new Scanner(System.in);
		double[] sides = new double[3];
		String color;
		boolean filled = false;
		String repeat = "yes";
	
		// create do/while loop that will run as long as repeat = yes
		do {
			System.out.println("Enter three sides; ");
			for (int i=0; i<sides.length; i++){
			sides[i] = input.nextDouble();
			}
			
			System.out.println("Enter the color: ");
			color = input.next();
		
			Triangle triangle =  new Triangle(sides[0], sides[1], sides[2], color);
		
			System.out.println("Enter true if you want to fill the triangle with the color: " + color + ". If you " +
				"do not want to fill the triangle with color please enter false.");
		
			filled = input.nextBoolean();
					
			if (filled == false){
				color = "No color";
				triangle.setColor(color);
			}
			
			System.out.println(triangle.getColor());
		
			triangle.setFilled(filled);
		
		
			// output information
			System.out.println();
			System.out.println("The area is " + triangle.getArea());
			System.out.println("The perimeter is " + triangle.getPerimeter());
			System.out.println("The color is " + triangle.getColor());
			System.out.println(triangle);
			System.out.println();
			
			System.out.println("Do you wish to enter new values? Please answer yes/no");
			repeat = input.next();
		} while (repeat.equalsIgnoreCase("yes"));
	}
}
