/**
 * Program: Ch12Prog2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Feb 14, 2013
 * Purpose: To create a 6x9 grid of 54 cards that are displayed in a random order.
 */

package Ch12.Prog2;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ch12Prog2 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	static int cards[] = new int[54];
	
	public Ch12Prog2(){
		
		for(int i=0;i<cards.length;i++)
			cards[i]= i+1;			
		shuffle(cards);
		
		
		setLayout(new GridLayout(6,9));
		
		for (int i=0;i<cards.length;i++){
			ImageIcon face = new ImageIcon("archives/Ch12/image/card/" + cards[i] + ".png");
			JLabel jlblCard = new JLabel();
			jlblCard.setIcon(face);
			add(jlblCard);
		}
	}
	
	private static void shuffle(int[] cards){
		for (int i=0;i<cards.length;i++){
			// generate an index randomly
			int index = (int)(Math.random() * cards.length);
			
			// swap myList[i] with myList[index]
			int temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}
	}
	
	public static void main(String[]args){
		JFrame frame = new Ch12Prog2();
		frame.setTitle("Chapter 12 Prog 2");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
