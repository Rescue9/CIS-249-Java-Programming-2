/**
 * Program: Ch19Lab3.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 19, 2013
 * Purpose: To split a file into multiple files
 */

package Ch19.Lab3;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ch19Lab3 extends JFrame {
	
	//Create components including text fields, and buttons
	private JTextField jtfInputFile = new JTextField(20);
	private JTextField jtfNumberOfFiles = new JTextField(2);
	private JButton jbtBrowse = new JButton("Browse");
	private JButton jbtStart = new JButton("Start");
	
	public Ch19Lab3(){
		// construct panels and add components to the panels
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(new JLabel("Enter or choose file:"), BorderLayout.WEST);
		panel1.add(jtfInputFile, BorderLayout.CENTER);
		panel1.add(jbtBrowse, BorderLayout.EAST);
		
		// create a second panel
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add(new JLabel("Specify the number of smaller files: "), BorderLayout.WEST);
		panel2.add(jtfNumberOfFiles, BorderLayout.CENTER);
	}
}
