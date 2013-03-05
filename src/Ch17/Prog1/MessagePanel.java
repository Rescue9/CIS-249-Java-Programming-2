/**
 * Program: MessagePanel.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 5, 2013
 * Purpose: Creates a message panel that will be used in the Ch17Prog1 class
 */

package Ch17.Prog1;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MessagePanel extends JPanel {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	JTextArea jtaWelcome = new JTextArea();

	public MessagePanel(){
		jtaWelcome.setText("Welcome to Java");
		add(jtaWelcome);
		}
	
	public void setTextBackground(Color bg){
		jtaWelcome.setBackground(bg);
	}
	
	public void moveTextRight(){
		if(jtaWelcome.getLocation().x + 10 < this.getWidth() - jtaWelcome.getWidth()){
			jtaWelcome.setLocation(jtaWelcome.getLocation().x + 10, jtaWelcome.getLocation().y);
			// System.out.println(jtaWelcome.getLocation()); // used for testing
			repaint();
		} else {
			System.out.println("Cannot complete request. Text will move offscreen.");
		}
		
	}
	
	public void moveTextLeft(){
		if(jtaWelcome.getLocation().x >= 11){
			jtaWelcome.setLocation(jtaWelcome.getLocation().x - 10, jtaWelcome.getLocation().y);
			// System.out.println(jtaWelcome.getLocation()); // used for testing
			repaint();
		} else {
			System.out.println("Cannot complete request. Text will move offscreen.");
		}
	}
}
