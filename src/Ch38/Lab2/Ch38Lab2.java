/**
 * Program: Ch38Lab2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 1, 2013
 * Purpose: To display file in a text area. JFileChooser will be demonstrated
 */

package Ch38.Lab2;

import java.io.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Ch38Lab2 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;  // eclipse complains

	// construct several objects
	private JButton jbtBrowse = new JButton("Browse");
	
	// text field to receive file name
	private JTextField jtfFile = new JTextField();
	
	// text area to display file
	private JTextArea jtaFileContent = new JTextArea();
	
	// create jFileChooser
	private JFileChooser jFileChooser = new JFileChooser();

	public Ch38Lab2() {
		// create a panel to hold a label, a text field, and a button
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("Filename"), BorderLayout.WEST);
		p.add(jtfFile, BorderLayout.CENTER);
		jtfFile.setBackground(Color.white);
		jtfFile.setForeground(Color.black);
		p.add(jbtBrowse, BorderLayout.EAST);
		
		// create a scrollable text area
		JScrollPane jsp = new JScrollPane(jtaFileContent);
		
		// set default directory to the current directory
		jFileChooser.setCurrentDirectory(new File("."));
		
		// use borderLayout for the frame
		setLayout(new BorderLayout());
		
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		jtaFileContent.setBackground(Color.white);
		jtaFileContent.setForeground(Color.black);
		
		// register listener
		jbtBrowse.addActionListener(this);
		jtfFile.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		// if the jbtBrowse button is selected, invoke the browse() method,
		// else invoce shotFile() method passing to it the value in the text field
		if(e.getSource() == jbtBrowse){
			browse();
		} else if (e.getSource() == jtfFile){
			showFile(new File(jtfFile.getText().trim()));
		}
	}
	
	private void browse(){
		// if the open file is selected get the selected file
		if(jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			showFile(jFileChooser.getSelectedFile());
		}
	}
	
	private void showFile(File file){
		BufferedReader infile = null; // declare buffered stream
		
		// get file name from the text field
		String inLine;
		
		jtfFile.setText(file.getName());
		
		try {
			// create a buffered stream
			infile = new BufferedReader(new FileReader(file));
			
			// read a line
			inLine = infile.readLine();
			
			boolean firstLine = true;
			
			// append the line to the text area
			while (inLine != null){
				if (firstLine){
					firstLine = false;
					jtaFileContent.append(inLine);
				} else {
					jtaFileContent.append("\n" + inLine);
				}
				
				inLine = infile.readLine();
			}
			
		} catch (FileNotFoundException ex){
			System.out.println("File not found:" + file.getName());
		} catch (IOException ex){
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (infile != null) infile.close();
			} catch (IOException ex){
				
			}
		}
	}
	
	public static void main(String[] args){
		Ch38Lab2 frame = new Ch38Lab2();
		frame.setSize(400, 300);
		frame.setTitle("Chapter 38 Lab 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center the frame
		frame.setVisible(true);
	}

}
