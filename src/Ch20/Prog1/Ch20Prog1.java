/**
 * Program: Ch20Prog1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 11, 2013
 * Purpose: To create the Koch snowflake fractal 
 */

package Ch20.Prog1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ch20Prog1 extends JFrame{
	// declare objects
	JTextField orderInput = new JTextField(5);
	JLabel orderLabel = new JLabel("Enter an Order");
	private Ch20Prog1Panel trianglePane = new Ch20Prog1Panel();
	
	public Ch20Prog1() {
		// setup order panel
		JPanel orderPanel = new JPanel();
		orderPanel.add(orderLabel);
		orderPanel.add(orderInput);
		
		orderInput.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderNum = ((JTextField) e.getSource()).getText();
				trianglePane.setOrder(Integer.parseInt(orderNum));
			}

			
		});
		
		this.setLayout(new BorderLayout());
		this.add(trianglePane, BorderLayout.CENTER);
		this.add(orderPanel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args){
		Ch20Prog1 frame = new Ch20Prog1();
		frame.setTitle("Chapter 20 Program 1");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	static class Ch20Prog1Panel extends JPanel	{
		
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


}
