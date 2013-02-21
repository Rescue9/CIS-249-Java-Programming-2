/**
 * Program: MyTectangle2D.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Feb 14, 2013
 * Purpose: To set the dimensions of a rectangle.
 */

package Ch16.Lab2;

public class MyRectangle2D {
	
	private double x,y; // Center of the rectangle
	private double height, width;
	
	public MyRectangle2D(){
		x=y=0;
		width = height =1;
	}
	
	public MyRectangle2D(double x, double y, double width, double height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getPerimeter(){
		return 2 * (width + height);
	}
	
	public double getArea(){
		return width*height;
	}
	
	public boolean contains(double x, double y){
		return Math.abs(x-this.x) <= width / 2 && Math.abs(y-this.y)<= height / 2;
	}
	
	// overload contains method
	public boolean contains(MyRectangle2D r){
		return contains(r.x - r.width / 2, r.y + r.height / 2)&&
				contains(r.x - r.width / 2, r.y - r.height / 2) &&
				contains(r.x + r.width / 2, r.y + r.height / 2) &&
				contains(r.x + r.width / 2, r.y - r.height / 2);
	}
	
	// why is this here? it's never called.
	/*public boolean overlaps(MyRectangle2D r){
		return Math.abs(this.x - r.x) <= (this.width + r.width) / 2 && Math.abs(this.y - r.y) <=
				(this.height + r.height) / 2;
	}*/ 

}
