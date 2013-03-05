/**
 * Program: Ch17Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 1, 2013
 * Purpose: To create an application that will draw a traffic light on the screen.
 * The change of light will depend on which radio button is pressed.
 */

package Ch17.Lab1;

import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Ch17Lab1 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains

	// declare radio buttons
	private JRadioButton jrbRed, jrbYellow, jrbGreen;
	
	// create a radio button group
	private ButtonGroup btg = new ButtonGroup();
	
	// create a traffic light display panel
	private Light light = new Light();
	
	
	/** main method */
	public static void main(String[] args){
		Ch17Lab1 frame = new Ch17Lab1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 170);
		frame.setLocationRelativeTo(null); // center the frame
		frame.setVisible(true);
	}
	
	/** default constructor */
	public Ch17Lab1(){
		setTitle("Chapter 17 Lab 1");
		
		// add traffic light panel to panel p1
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(light);
		
		// put the radio button in panel p2
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(jrbRed = new JRadioButton("Red"));
		p2.add(jrbYellow = new JRadioButton("Yellow"));
		p2.add(jrbGreen = new JRadioButton("Green"));
		
		// set keyboard mnemonics
		jrbRed.setMnemonic('R');
		jrbYellow.setMnemonic('Y');
		jrbGreen.setMnemonic('G');
		
		// group radio buttons
		btg.add(jrbRed);
		btg.add(jrbYellow);
		btg.add(jrbGreen);
		
		// place p1 and p2 in the frame
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		// register listeners for radio buttons
		jrbRed.addItemListener(new MyItemEventListener());
		jrbYellow.addItemListener(new MyItemEventListener());
		jrbGreen.addItemListener(new MyItemEventListener());
		
		// set initial light freen
		jrbGreen.setSelected(true);
		light.turnOnGreen();
	}
	
	class MyItemEventListener implements ItemListener {
		/** Handle checkbox events */
		@Override
		public void itemStateChanged(ItemEvent e){
			if (jrbRed.isSelected()){
				light.turnOnRed(); // set red light
			}
			if (jrbYellow.isSelected()){
				light.turnOnYellow(); // set yellow light
			}
			if (jrbGreen.isSelected()){
				light.turnOnGreen(); // set green light
			}
		}
	}
	
	// three traffic lights shown in a panel
	class Light extends JPanel {
		
		private static final long serialVersionUID = 1L; // eclipse complains
		private boolean red;
		private boolean yellow;
		private boolean green;
		
		/** default constructor */
		public Light() {
		}
		
		/** set red light on */
		public void turnOnRed(){
			red = true;
			yellow = false;
			green = false;
			repaint();
		}
		
		/** set yellow light on */
		public void turnOnYellow(){
			red = false;
			yellow = true;
			green = false;
			repaint();
		}
		
		/** set green light on */
		public void turnOnGreen(){
			red = false;
			yellow = false;
			green = true;
			repaint();
		}
		
		@Override
		/** display lights */
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			if (red) {
				g.setColor(Color.RED);
				g.fillOval(10, 10, 20, 20);
				g.setColor(Color.BLACK);
				g.drawOval(10, 35, 20, 20);
				g.drawOval(10, 60, 20, 20);
				g.drawRect(5, 5, 30, 80);
				}
			else if (yellow) {
				g.setColor(Color.yellow);
				g.fillOval(10, 35, 20, 20);
				g.setColor(Color.black);
				g.drawRect(5, 5, 30, 80);
				g.drawOval(10, 10, 20, 20);
				g.drawOval(10, 60, 20, 20);
				}
			else if (green) {
				g.setColor(Color.green);
				g.fillOval(10, 60, 20, 20);
				g.setColor(Color.black);
				g.drawRect(5, 5, 30, 80);
				g.drawOval(10, 10, 20, 20);
				g.drawOval(10, 35, 20, 20);
				}
			else {
				g.setColor(Color.black);
				g.drawRect(5, 5, 30, 80);
				g.drawOval(10, 10, 20, 20);
				g.drawOval(10, 35, 20, 20);
				g.drawOval(10, 60, 20, 20);
				}
		}
		
		/** set preferred size */
		public Dimension getPreferredSize(){
			return new Dimension(40, 90);
		}
		
	}
	
	

}
