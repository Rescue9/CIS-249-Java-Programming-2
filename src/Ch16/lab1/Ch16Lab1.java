/**
 * Program: Ch16Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Feb 9, 2013
 * Purpose: To create an application that will display a polygon
 * with buttons for increasing and decreasing the number of sides
 * for said polygon.
 */

package Ch16.lab1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Ch16Lab1 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	// create our components
	private JButton jbtEnlarge = new JButton("+1");
	private JButton jbtShrink = new JButton("-1");
	private RegularPolygonPanel canvas = new RegularPolygonPanel();
	
	// added my own components to learn a bit more
	private JLabel jlblNumberOfSides = new JLabel("Number of Sides: ");
	private JLabel jlblSidesTotal = new JLabel(""+canvas.getNumberOfSides());
	
	public Ch16Lab1(){
		
		JPanel panel = new JPanel(); // use the panel to group buttons
		panel.add(jbtEnlarge);
		panel.add(jbtShrink);
		
		JPanel panel2 = new JPanel(); // secondary panel to display total number of sides
		panel2.add(jlblNumberOfSides);
		panel2.add(jlblSidesTotal);
		
		
		add(canvas, BorderLayout.NORTH); // add canvas to top
		add(panel, BorderLayout.CENTER); // add button to the frame
		add(panel2, BorderLayout.SOUTH); // add the labels to the center

		
		jbtEnlarge.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.setNumberOfSides(canvas.getNumberOfSides() + 1);
				jlblSidesTotal.setText(""+canvas.getNumberOfSides()); // used to set the total sides text
				canvas.requestFocusInWindow();
			}
		});
		
		jbtShrink.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.setNumberOfSides(canvas.getNumberOfSides() - 1);
				if(canvas.getNumberOfSides() <= 3){
					JOptionPane.showMessageDialog(null, "You have reached the smallest " +
							"number of sides for it to still be a polygon.\n The number " +
							"of sides cannot decrease below 3");
					canvas.setNumberOfSides(3);
				}
				canvas.requestFocusInWindow();
				jlblSidesTotal.setText(""+canvas.getNumberOfSides());
			}
		});
		
		canvas.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getButton() == MouseEvent.BUTTON1){
					canvas.setNumberOfSides(canvas.getNumberOfSides() + 1);
				jlblSidesTotal.setText(""+canvas.getNumberOfSides());
				}
				else if(e.getButton() == MouseEvent.BUTTON3){
					canvas.setNumberOfSides(canvas.getNumberOfSides() - 1);
				jlblSidesTotal.setText(""+canvas.getNumberOfSides());
				}
			}
		});
		
		canvas.setFocusable(true);
		canvas.requestFocusInWindow();
		
		canvas.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_UP){
					canvas.setNumberOfSides(canvas.getNumberOfSides() + 1);
				jlblSidesTotal.setText(""+canvas.getNumberOfSides());
				}
				else if (e.getKeyCode() == KeyEvent.VK_DOWN){
					canvas.setNumberOfSides(canvas.getNumberOfSides() - 1);
				jlblSidesTotal.setText(""+canvas.getNumberOfSides());
				}
			}
		});
	}
	
	public static void main(String[] args){
		JFrame frame = new Ch16Lab1();
		frame.setTitle("Chapter 16 Lab 1");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(200, 200); // needed to pack frame to fit extra panel
		frame.pack();
		frame.setVisible(true);	
	}

}
