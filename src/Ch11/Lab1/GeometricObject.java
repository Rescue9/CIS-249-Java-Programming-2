/*
 * Program: GeometricObject.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 17, 2013
 * Purpose: This class will contain the basic attributes for all shapes and is not just limited to triangles.
 */

package Ch11.Lab1;

public abstract class GeometricObject {
	
	// declare variables
	private String color;
	private boolean filled;
	
	/** Default Construct */
	protected GeometricObject() {
		color = "white";
		filled = true;
	}
	
	/** Construct a geometric object */
	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	
	/** Getter method for color */
	public String getColor(){
		return color;
	}
	
	/** Setter method for color */
	public void setColor(String color){
		this.color = color;
	}
	
	/** Getter method for filled. Since filled is boolean, so,
	 * the get method name is isFilled
	 */
	public boolean isFilled(){
		return filled;
	}
	
	/** Setter method for filled*/
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	/** Abstract method findArea */
	public abstract double getArea();
	
	/** Abstract method getPerimeter */
	public abstract double getPerimeter();

}
