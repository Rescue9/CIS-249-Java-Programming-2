/**
 * Program: Ch12Prog1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Feb 8, 2013
 * Purpose: To create a frame with two panels, each containing 3 buttons.
 */

package Ch12.Prog1;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ch12Prog1 extends JFrame {
	
	private static final long serialVersionUID = 1L; //eclipse complains

	public Ch12Prog1(){
		setLayout(new FlowLayout());
		
		JPanel jplLeft = new JPanel();
		JPanel jplRight = new JPanel();
		
		jplLeft.setLayout(new FlowLayout());
		jplRight.setLayout(new FlowLayout());
		
		
		JButton btn1 = new JButton("Button 1");
		JButton btn2 = new JButton("Button 2");
		JButton btn3 = new JButton("Button 3");
		JButton btn4 = new JButton("Button 4");
		JButton btn5 = new JButton("Button 5");
		JButton btn6 = new JButton("Button 6");	
		
		jplLeft.add(btn1);
		jplLeft.add(btn2);
		jplLeft.add(btn3);
		
		jplRight.add(btn4);
		jplRight.add(btn5);
		jplRight.add(btn6);
		
		this.add(jplLeft);
		this.add(jplRight);
	}
	
	public static void main(String[]args){
		
		Ch12Prog1 frame = new Ch12Prog1();
		frame.setTitle("Chapter 12 Program 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
