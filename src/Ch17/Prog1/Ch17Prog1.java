/**
 * Program: Ch17Prog1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 5, 2013
 * Purpose: To create a panel with text & radio buttons that will change attributes of text panel.
 */

package Ch17.Prog1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ch17Prog1 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains

	// create messagepanel object
	MessagePanel textPanel = new MessagePanel();
		
	// create radio panel
	JPanel radioPanel = new JPanel();
	
	// create l/r button panel
	JPanel lrPanel = new JPanel();
	
	// create radio buttons
	private JRadioButton jrbRed, jrbYellow, jrbWhite, jrbGray, jrbGreen;
	
	// group the buttons
	private ButtonGroup btnGroup = new ButtonGroup();	
	
	// create l/r buttons
	JButton lButton = new JButton("<=");
	JButton rButton = new JButton("=>");
		
	public Ch17Prog1(){
		
		
		// add buttons to panel
		radioPanel.add(jrbRed = new JRadioButton("Red"));
		radioPanel.add(jrbYellow = new JRadioButton("Yellow"));
		radioPanel.add(jrbWhite = new JRadioButton("White"));
		radioPanel.add(jrbGray = new JRadioButton("Gray"));
		radioPanel.add(jrbGreen = new JRadioButton("Green"));
		
		// group buttons
		btnGroup.add(jrbRed);
		btnGroup.add(jrbYellow);
		btnGroup.add(jrbWhite);
		btnGroup.add(jrbGray);
		btnGroup.add(jrbGreen);
		
		// create listeners for buttons
		jrbRed.addItemListener(new MyRadioButtonListener());
		jrbYellow.addItemListener(new MyRadioButtonListener());
		jrbWhite.addItemListener(new MyRadioButtonListener());
		jrbGray.addItemListener(new MyRadioButtonListener());
		jrbGreen.addItemListener(new MyRadioButtonListener());
		
		lrPanel.setLayout(new FlowLayout());
		
		lrPanel.add(lButton);
		lrPanel.add(rButton);
				
		// create listener for buttons
		lButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.moveTextLeft();
			}
		});
		rButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.moveTextRight();
			}
		});
		
		
		add(radioPanel, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(lrPanel, BorderLayout.SOUTH);		
	}
	
	public static void main(String[] args){
		Ch17Prog1 prog1 = new Ch17Prog1();
		prog1.setTitle("Chapter 17 Program 1");
		prog1.pack();
		prog1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prog1.setLocationRelativeTo(null);
		prog1.setVisible(true);		
	}
	
	class MyRadioButtonListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (jrbRed.isSelected()){
				textPanel.setBackground(Color.RED);
				textPanel.setTextBackground(Color.RED);
			}
			if (jrbYellow.isSelected()){
				textPanel.setBackground(Color.YELLOW);
				textPanel.setTextBackground(Color.YELLOW);
			}
			if (jrbWhite.isSelected()){
				textPanel.setBackground(Color.WHITE);
				textPanel.setTextBackground(Color.WHITE);
			}
			if (jrbGray.isSelected()){
				textPanel.setBackground(Color.GRAY);
				textPanel.setTextBackground(Color.GRAY);
			}
			if (jrbGreen.isSelected()){
				textPanel.setBackground(Color.GREEN);
				textPanel.setTextBackground(Color.GREEN);
			}
			
		}
		
	}
}
