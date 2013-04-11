/**
 * Program: Ch38Prog2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 11, 2013
 * Purpose: To display inputed text in a selected color
 */

package Ch38.Prog2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ch38Prog2 extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	// declare graphical items
	JButton blue = new JButton("Blue");
	JButton black = new JButton("Black");
	JButton darkGray = new JButton("Dark Gray");
	JButton gray = new JButton("Gray");
	JButton red = new JButton("Red");
	JButton magenta = new JButton("Magenta");
	
	JTextField inputArea= new JTextField();
	JMenuBar mb = new JMenuBar();


	public Ch38Prog2() {
		// create textarea panel
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1,1));
		textPanel.add(inputArea);
		
		// button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,2));
		buttonPanel.add(blue);
		buttonPanel.add(black);
		buttonPanel.add(darkGray);
		buttonPanel.add(gray);
		buttonPanel.add(red);
		buttonPanel.add(magenta);
		
		this.setLayout(new BorderLayout());
		this.add(textPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.setJMenuBar(mb);
		
		createButtons();
		createMenu();
	}
	
	public static void main(String[] args){
		Ch38Prog2 frame = new Ch38Prog2();
		frame.setName("Chapter 38 Program 2");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void createButtons(){
		// button action listeners
		blue.addActionListener(this);
		black.addActionListener(this);
		darkGray.addActionListener(this);
		gray.addActionListener(this);
		red.addActionListener(this);
		magenta.addActionListener(this);
		
		// set color properties
		blue.setBackground(Color.blue);
		blue.setForeground(Color.white);
		black.setBackground(Color.black);
		black.setForeground(Color.white);
		darkGray.setBackground(Color.darkGray);
		darkGray.setForeground(Color.white);
		gray.setBackground(Color.gray);
		gray.setForeground(Color.white);
		red.setBackground(Color.red);
		red.setForeground(Color.white);
		magenta.setBackground(Color.magenta);
		magenta.setForeground(Color.white);
	}
	
	public void createMenu(){
		
		JMenu file = new JMenu("File");
		file.setMnemonic('f');
		mb.add(file);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic('e');
		mb.add(edit);
		
		JMenu about = new JMenu("About");
		about.setMnemonic('a');
		mb.add(about);
		
		JMenuItem display = new JMenuItem("Display");
		display.setMnemonic('d');
		display.addActionListener(this);
		file.add(display);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		exit.addActionListener(this);
		file.add(exit);
		
		JMenuItem clear = new JMenuItem("Clear");
		clear.setMnemonic('c');
		clear.addActionListener(this);
		edit.add(clear);
		
		JMenuItem aboutDesc = new JMenuItem("About Color Buttons");
		aboutDesc.setMnemonic('b');
		aboutDesc.addActionListener(this);
		about.add(aboutDesc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// button actions
		if (e.getSource().equals(blue)){
			changeText(Color.blue);
		}
		if (e.getSource().equals(black)){
			changeText(Color.black);
		}
		if (e.getSource().equals(darkGray)){
			changeText(Color.darkGray);
		}
		if (e.getSource().equals(gray)){
			changeText(Color.gray);
		}
		if (e.getSource().equals(red)){
			changeText(Color.red);
		}
		if (e.getSource().equals(magenta)){
			changeText(Color.magenta);
		}
		
		// menu actions
		if (e.getActionCommand().equals("Display")){
			setDefaultText();
		}
		if (e.getActionCommand().equals("Exit")){
			System.exit(1);
		}
		if (e.getActionCommand().equals("Clear")){
			inputArea.setText("");
			setDefaultText();
		}
		if (e.getActionCommand().equals("About Color Buttons")){
			JOptionPane.showMessageDialog(null, "This program changes the color of the text area to the seleced button's color.", "About Color Buttons", JOptionPane.INFORMATION_MESSAGE);		}
	}
	
	public void changeText(Color color){
		inputArea.setForeground(Color.white);
		inputArea.setBackground(color);
		
	}
	
	public void setDefaultText(){
		inputArea.setForeground(Color.black);
		inputArea.setBackground(Color.white);
	}

}
