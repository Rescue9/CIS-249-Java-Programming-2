/**
 * Program: Ch17Lab3.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 1, 2013
 * Purpose: To adjust a text's color based upon RGB Scrollbar values
 */

package Ch17.Lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ch17Lab3 extends JFrame {

	private static final long serialVersionUID = 1L; // eclipse complains

	// declare scrollbars
	private JScrollBar jscbRed, jscbGreen, jscbBlue;
	
	// create a label
	private JLabel jlbl = new JLabel("Show Colors", JLabel.CENTER);
	
	// declare color component values
	private int redValue, greenValue, blueValue;
	
	// main method
	public static void main(String[] args) {
		Ch17Lab3 frame = new Ch17Lab3();
		frame.setSize(300, 200);
		frame.setTitle("Chapter 17 Lab 3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public Ch17Lab3(){
		// panel p1 to hold new labels
		JPanel p1 = new JPanel(new GridLayout(3,1));
		p1.add(new JLabel("Red"));
		p1.add(new JLabel("Green"));
		p1.add(new JLabel("Blue"));
		
		// panel p2 to hold scrollbars
		JPanel p2 = new JPanel(new GridLayout(3,1));
		p2.add(jscbRed = new JScrollBar());
		jscbRed.setOrientation(JScrollBar.HORIZONTAL);
		jscbRed.setMaximum(255);
		
		p2.add(jscbGreen = new JScrollBar());
		jscbGreen.setOrientation(JScrollBar.HORIZONTAL);
		jscbGreen.setMaximum(255);
		
		p2.add(jscbBlue = new JScrollBar());
		jscbBlue.setOrientation(JScrollBar.HORIZONTAL);
		jscbBlue.setMaximum(255);
		
		JPanel p = new JPanel(new BorderLayout(10, 10));
		p.add(p1, BorderLayout.WEST);
		p.add(p2, BorderLayout.CENTER);
		
		add(jlbl, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		// register listeners for the scroll bars
		jscbRed.addAdjustmentListener(new Listener());
		jscbGreen.addAdjustmentListener(new Listener());
		jscbBlue.addAdjustmentListener(new Listener());
		
		p.setBorder(new CompoundBorder(new TitledBorder("Choose colors"), new EmptyBorder(2,2,2,2)));
	}
	class Listener implements AdjustmentListener {
		
		public void adjustmentValueChanged(AdjustmentEvent e){
			if (e.getSource() == jscbRed)
				redValue = jscbRed.getValue();
			else if (e.getSource() == jscbGreen)
				greenValue = jscbGreen.getValue();
			else if (e.getSource() == jscbBlue)
				blueValue = jscbBlue.getValue();
			
			Color color = new Color(redValue, greenValue, blueValue);
			jlbl.setForeground(color);
		}
	}
}
