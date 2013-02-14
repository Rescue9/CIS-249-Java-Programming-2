/**
 * Program: Ch12Lab3.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: February 4, 2013
 * Purpose: To display a set of four cards. Card 1 & 3 are displayed on
 * mouseOver events. Card 2 & 4 are displayed on buttonPress events.
 */

package Ch12.Lab3;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ch12Lab3 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains

	public Ch12Lab3(){
		
		setLayout(new GridLayout(1,4));
		
		int[] list = new int[54];
		for (int i=0;i< list.length; i++)
			list[i] = i+1;
		shuffle(list);
		
		ImageIcon backCover = new ImageIcon("archives/Ch12/image/card/backCard.png");
		JButton jbt1 = new JButton(backCover);
		JButton jbt2 = new JButton(backCover);
		JButton jbt3 = new JButton(backCover);
		JButton jbt4 = new JButton(backCover);
		
		add(jbt1);
		add(jbt2);
		add(jbt3);
		add(jbt4);
		
		jbt1.setRolloverIcon(new ImageIcon("archives/Ch12/image/card/" + list[0] + ".png"));
		jbt2.setPressedIcon(new ImageIcon("archives/Ch12/image/card/" + list[1] + ".png"));
		jbt3.setRolloverIcon(new ImageIcon("archives/Ch12/image/card/" + list[2] + ".png"));
		jbt4.setPressedIcon(new ImageIcon("archives/Ch12/image/card/" + list[3] + ".png"));
	}
	
	public static void shuffle(int[] list){
		for (int i=0;i<list.length;i++){
			// generate an index randomly
			int index = (int)(Math.random() * list.length);
			
			// swap myList[i] with myList[index]
			int temp = list[i];
			list[i] = list[index];
			list[index] = temp;
		}
	}
	
	public static void main(String[] args){
		Ch12Lab3 frame = new Ch12Lab3();
		frame.setTitle("Chapter 12 Lab 3");
		frame.setSize(300, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
