/**
 * Program: Ch16Lab2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Feb 15, 2013
 * Purpose: To add and remove points from a box via mouse buttons.
 */

package Ch16.Lab2;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Ch16Lab2 extends JFrame{
	
	private static final long serialVersionUID = 1L; // eclipse complains

	public Ch16Lab2(){
		add(new View());
	}
	
	/** Main method*/
	public static void main(String[] args){
		Ch16Lab2 frame = new Ch16Lab2();
		frame.setTitle("Chapter 16 Lab 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 400);
		frame.setLocationRelativeTo(null); // center the frame
		frame.setVisible(true);
	}
	
	class View extends JPanel {
		
		private static final long serialVersionUID = 1L; // eclipse complains
		
		private ArrayList<Vertex> list = new ArrayList<Vertex>();
		
		View(){
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if(e.getButton() == MouseEvent.BUTTON1){
						// Add a vertex
						list.add(new Vertex(e.getPoint()));
						repaint();
					}
					else if (e.getButton() == MouseEvent.BUTTON3){
						// remove a vertex
						Vertex c = getContainingVertex(e.getPoint());
						if(c != null){
							list.remove(c);
							repaint();
						}
					}
				}
			});
		}
		
		Vertex getContainingVertex(Point p){
			for (int i = 0; i < list.size(); i++)
				if (((Vertex)list.get(i)).contains(p))
					return (Vertex)(list.get(i));
			
			return null;
		}
		
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.setColor(Color.RED);
			for (int i = 0; i < list.size(); i ++){
				g.drawOval(((Vertex)list.get(i)).getX() - Vertex.RADIUS,
						((Vertex)list.get(i)).getY() - Vertex.RADIUS, 2* Vertex.RADIUS, 2* Vertex.RADIUS);
			}
			
			drawInstructions(g, 20, 20);
			
			// draw the bounding rectangle
			if (list.size() > 0){
				MyRectangle2D rectangle = getRectangle(list);
				g.drawRect((int)(rectangle.getX() - rectangle.getWidth() / 2 - Vertex.RADIUS),
						(int)(rectangle.getY() - rectangle.getHeight() / 2 - Vertex.RADIUS),
						(int)(rectangle.getWidth() + 2 * Vertex.RADIUS),
						(int)(rectangle.getHeight() + 2 * Vertex.RADIUS));
			}
		}
		
		final String[] instructions = {"INSTRUCTIONS", "Add:", "Left Click", "Remove:", "Right Click"};
		
		void drawInstructions(Graphics g, int x, int y){
			g.setColor(Color.BLACK);
			g.drawRect(x, y, x+130, y+50);
			g.drawString(instructions[0], x+10, y+20);
			
			for (int i = 1; i< instructions.length; i += 2){
				g.drawString(instructions[i], x+10, y+20+(i+1) * 10);
				g.drawString(instructions[i+1], x+80, y+20+(i+1) * 10);
			}
		}
	}
	
	static class Vertex {
		
		final static int RADIUS = 10;
		int x,y;
		
		public Vertex(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public Vertex(Point p){
			this(p.x,p.y);
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		public boolean equals(Object o){
			Vertex c= (Vertex)o;
			return c.getX() == x && c.getY() == y;
		}
		
		public double getDistance(Vertex c){
			return getDistance(x, y, c.x, c.y);
		}
		
		public static double getDistance(Vertex c1, Vertex c2){
			return getDistance(c1.x, c1.y, c2.x, c2.y);
		}
		
		public static double getDistance(double x1, double y1, double x2, double y2){
			return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		}
		
		public boolean contains(Point p){
			return getDistance(x, y, p.x, p.y) <= RADIUS;
		}
	}
	
	public static MyRectangle2D getRectangle(ArrayList<?> list){
		double[][] points = new double[list.size()][2];
		
		for (int i = 0; i < points.length; i++){
			points[i][0] = ((Vertex)(list.get(i))).x;
			points[i][1] = ((Vertex)(list.get(i))).y;
		}
		
		return getRectangle(points);
	}
	
	public static MyRectangle2D getRectangle(double[][] points){
		double minX = minX(points);
		double minY = minY(points);
		double maxX = maxX(points);
		double maxY = maxY(points);
		
		return new MyRectangle2D( (minX + maxX) / 2, (minY + maxY) / 2, maxX - minX, maxY - minY);
	}
	
	private static double minX(double[][] points){
		double minX = points[0][0];
		
		for (int i = 0; i < points.length; i++)
			if (minX > points[i][0])
				minX = points[i][0];
			
		return minX;
	}
	
	private static double maxX(double[][]points){
		double maxX = points[0][0];
		
		for (int i = 0; i < points.length; i++)
			if (maxX < points[i][0])
				maxX = points[i][0];
		
		return maxX;
	}
	
	private static double minY(double[][] points){
		double minY = points[0][1];
		
		for (int i = 0; i < points.length; i++)
			if (minY > points[i][1])
				minY = points [i][1];
		
		return minY;
	}
	
	private static double maxY(double[][] points){
		double maxY = points[0][1];
		
		for (int i = 0; i < points.length; i++)
			if (maxY < points[i][1])
				maxY = points[i][1];
		
		return maxY;
	}
}
