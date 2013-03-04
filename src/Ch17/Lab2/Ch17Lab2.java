/**
 * Program: Ch17Lab2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 3, 2013
 * Purpose: Driver for Histogram class
 */

package Ch17.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.util.Scanner;


public class Ch17Lab2 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	int[]counts = new int[26];
	private JTextField jtf = new JTextField(20);
	private Histogram display = new Histogram();
	
	public Ch17Lab2(){
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("Text File"), BorderLayout.WEST);
		p.add(jtf, BorderLayout.CENTER);
		
		display.setBorder(new LineBorder(Color.red, 1));
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.SOUTH);
		add(display, BorderLayout.CENTER);
		
		jtf.addActionListener(new Listener());
	}
	
	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			// reset counts
			for (int i = 0; i < 26; i++){
				counts[i]=0;
			}
			
			try {
				// create file input stream
				Scanner input = new Scanner(new File(jtf.getText().trim()));
				
				while (input.hasNext()){
					String line = input.nextLine();
					
					for (int i = 0; i < line.length(); i++){
						if (Character.isLetter(line.charAt(i))){
							counts[Character.toUpperCase(line.charAt(i)) - 'A']++;
						}
					}
				}
				
				display.showHistogram(counts);
			} catch (FileNotFoundException ex){
				System.out.println("File not found: " + jtf.getText().trim());
			}
		}
	}
	
	public static void main(String[] args){
		Ch17Lab2 frame = new Ch17Lab2();
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Chapter 17 Lab 2");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
