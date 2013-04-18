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
	
	private static final long serialVersionUID = 1L; // eclipse complains
	// declare objects
	JTextField orderInput = new JTextField(5);
	JLabel orderLabel = new JLabel("Enter an Order");
	private Ch20Prog1Panel snowFlakePane = new Ch20Prog1Panel();
	
	public Ch20Prog1() {
		// setup order panel
		JPanel orderPanel = new JPanel();
		orderPanel.add(orderLabel);
		orderPanel.add(orderInput);
		
		orderInput.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderNum = ((JTextField) e.getSource()).getText();
				snowFlakePane.setOrder(Integer.parseInt(orderNum));
			}

			
		});
		
		this.setLayout(new BorderLayout());
		this.add(snowFlakePane, BorderLayout.CENTER);
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
			// and here is where my math fu broke down. I needed help with the equations.

			int side = (int)(Math.min(getWidth(), getHeight()) * 0.8D);
			int triangleHeight = (int)(side * Math.sin(Math.toRadians(60.0D)));

			Point p1 = new Point(getWidth() / 2, 10);
			Point p2 = new Point(getWidth() / 2 - side / 2, 10 + triangleHeight);
			Point p3 = new Point(getWidth() / 2 + side / 2, 10 + triangleHeight);
			
			displayKochSnowFlake(g, order, p1, p2);
			displayKochSnowFlake(g, order, p2, p3);
			displayKochSnowFlake(g, order, p3, p1);
						
		}
		
		private static void displayKochSnowFlake(Graphics g, int order, Point p1, Point p5) {
			int changeX = p5.x - p1.x;
			int changeY = p5.y - p1.y;
			
			Point p2, p3, p4;
			
			if (order == 0){
				g.drawLine(p1.x, p1.y, p5.x, p5.y);
			}
			else {
				// and here is where my math fu broke down. I needed help with the equations.
				p2 = new Point (p1.x + changeX / 3, p1.y + changeY / 3);
				p3 = new Point ((int)((p1.x + p5.x) / 2 + Math.cos(Math.toRadians(30.0D)) * (p1.y - p5.y) / 3.0D),
						(int)((p1.y + p5.y) / 2 + Math.cos(Math.toRadians(30.0D)) * (p5.x - p1.x) / 3.0D));
				p4 = new Point (p1.x + changeX * 2/3, p1.y + changeY *2/3);
				
				displayKochSnowFlake(g, order - 1, p1, p2);
				displayKochSnowFlake(g, order - 1, p2, p3);
				displayKochSnowFlake(g, order - 1, p3, p4);
				displayKochSnowFlake(g, order - 1, p4, p5);
			}
		}
	}
}