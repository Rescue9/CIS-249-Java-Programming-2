/**
 * Program: Ch20Lab2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 8, 2013
 * Purpose: to create Sierpinski tirangle within gui application
 * by adding or subtracting triangles
 */

package Ch20.Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ch20Lab2 extends JApplet implements ActionListener {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	// create buttons and panel
	private JButton jbtLeft = new JButton(" <-- "); // no GIF's
	private JButton jbtRight = new JButton(" --> "); // no GIF's
	private Chapter20Lab2Panel trianglePanel = new Chapter20Lab2Panel(); // to display the pattern
	
	

	public Ch20Lab2() {

		// panel to hold label, text field, and a button
		JPanel panel = new JPanel();
		panel.add(jbtLeft);
		panel.add(jbtRight);
		
		// add a Sierpinski Triangle panel to the applet
		add(trianglePanel);
		add(panel, BorderLayout.SOUTH);
		
		// register a listener
		jbtLeft.addActionListener(this);
		jbtRight.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
		// check to seee which button is pressed
		if(e.getSource() == jbtLeft){
			if(trianglePanel.getOrder()<=0){
				return;
			}
			trianglePanel.setOrder(trianglePanel.getOrder() - 1);
		}
		else if ( e.getSource() == jbtRight){
			trianglePanel.setOrder(trianglePanel.getOrder() + 1);
		}
	}
	
	static class Chapter20Lab2Panel extends JPanel	{
		
		private static final long serialVersionUID = 1L; // eclipse complains
		private int order = 0;
		
		/** Return order */
		public int getOrder(){
			return order;
		}
		
		/** Set a new order	*/
		public void setOrder(int order){
			this.order = order;
			repaint();
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			// select three points in proportion to the panel size
			Point p1 = new Point(getWidth() / 2, 10);
			Point p2 = new Point(10, getHeight() - 10);
			Point p3 = new Point(getWidth() - 10, getHeight() - 10);
			
			displayTriangles(g, order, p1, p2, p3);
		}
		
		private static void displayTriangles(Graphics g, int order, Point p1, Point p2, Point p3){
			
			if(order >=0){
				// draw a triangle to connect three points
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
				g.drawLine(p1.x, p1.y, p3.x, p3.y);
				g.drawLine(p2.x, p2.y, p3.x, p3.y);
				
				// get three midpoints in the triangle
				Point midBetweenP1P2 = midpoint(p1,p2);
				Point midBetweenP2P3 = midpoint(p2,p3);
				Point midBetweenP3P1 = midpoint(p3,p1);
				
				// recursively display three tirangles
				displayTriangles(g, order - 1 , p1, midBetweenP1P2, midBetweenP3P1);
				displayTriangles(g, order - 1 , midBetweenP1P2, p2, midBetweenP2P3);
				displayTriangles(g, order - 1 , midBetweenP3P1, midBetweenP2P3, p3);
			}
		}
		
		private static Point midpoint(Point p1, Point p2){
			
			return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
		}
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Chapter 20 Lab 2");
		Ch20Lab2 applet = new Ch20Lab2();
		frame.add(applet);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
