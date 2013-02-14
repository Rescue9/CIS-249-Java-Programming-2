/**
 * Program: Ch12Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 19, 2013
 * Purpose: To display a gui with 4 lines of text.
 */

package Ch12.Lab1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.Color;

public class Ch12Lab1 extends JFrame{
	
	private static final long serialVersionUID = 1L; //eclipse complains

	public Ch12Lab1(){
		JLabel jlbl1 = new JLabel("Department of Computer Science");
		JLabel jlbl2 = new JLabel("School of Computing");
		JLabel jlbl3 = new JLabel("Armstrong Atlantic State University");
		JLabel jlbl4 = new JLabel("Tel: (912) 921-6444");
		
		jlbl1.setBorder(new LineBorder(Color.BLUE, 1));
		jlbl2.setBorder(new LineBorder(Color.BLUE, 1));
		jlbl3.setBorder(new LineBorder(Color.BLUE, 1));
		jlbl4.setBorder(new LineBorder(Color.BLUE, 1));
		
		setLayout(new GridLayout(4, 1));
		
		add(jlbl1);
		add(jlbl2);
		add(jlbl3);
		add(jlbl4);
	}
	
	public static void main(String[] args){
		Ch12Lab1 frame = new Ch12Lab1();
		frame.setTitle("Chapter 12 Lab 1");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center the frame
		frame.setVisible(true);
	}

}
