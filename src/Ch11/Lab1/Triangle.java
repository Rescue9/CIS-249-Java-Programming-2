/*
 * Program: Triangle.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 17, 2013
 * Purpose: A class that extends GeometricObject
 */

package Ch11.Lab1;

public class Triangle extends GeometricObject {
	
	// declare variables for the sides of the triangle and its color
	private double side1, side2, side3;
	private String color;
	
	/** Default Constructor */
	public Triangle() {
		side1 = 0.0;
		side2 = 0.0;
		side3 = 0.0;
		color = "No color";
	}
	
	/** Constructor */
	public Triangle(double side1, double side2, double side3, String color) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.color = color;
	}
	
	public double getSide1(){
		return side1;
	}
	
	public double getSide2(){
		return side2;
	}
	
	public double getSide3(){
		return side3;
	}
	
	
	/** Override method findArea in GeometricObject */
	@Override
	public double getArea(){
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	/** Implement the abstract method findCircumference in
	 * GeometricObject
	 */
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
	
	public String toString(){
		// Implement it to return the three sides and the color
		return "Triangle side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3 + " color = " + color;
	}

}
