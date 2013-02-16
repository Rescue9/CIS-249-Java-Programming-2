/**
 * Program: Ch16Prog1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Feb 16, 2013
 * Purpose: Write a program that moves the ball in a panel. You should define
 * a panel class for displaying the ball and provide the methods for moving the ball
 * left, right, up, and down, as shown in Figure 16.21b. Check the boundary to prevent
 * the ball from moving out of sight completely.
 */

package Ch16.Prog1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ch16Prog1 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	private static final int PANEL_WIDTH = 400;
	private static final int PANEL_HEIGHT = 300;
	
	public Ch16Prog1(){
		
		this.setLayout(new BorderLayout());
		
		// top panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		panel.add(new OvalComponent());
		
		// button panel
		JPanel buttonPanel = new JPanel();
		
		JButton jbtnLeft = new JButton("Left");
		JButton jbtnRight = new JButton("Right");
		JButton jbtnUp = new JButton("Up");
		JButton jbtnDown= new JButton("Down");
		
		buttonPanel.setLayout(new FlowLayout());
		
		buttonPanel.add(jbtnLeft);
		buttonPanel.add(jbtnRight);
		buttonPanel.add(jbtnUp);
		buttonPanel.add(jbtnDown);
		
		this.add(panel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	static class OvalComponent extends JComponent {
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawOval(PANEL_HEIGHT / 2, PANEL_WIDTH / 2, 20, 20);
		}
	}
	
	public static void main(String[]args){
		Ch16Prog1 frame = new Ch16Prog1();
		frame.setTitle("Chapter 16 Program 1");
		frame.setSize(PANEL_WIDTH,PANEL_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
