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

public class Ch19Lab3 extends JFrame {
	
	private static final long serialVersionUID = 1L; //eclipse complains
	
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
		
		// construct main panel, a text area and set text area's wrapping
		JPanel panel = new JPanel(new GridLayout(4,1));
		JTextArea jta = new JTextArea("If you split a file named temp.txt into 3 smaller files, the three smaller files are temp.txt.1, temp.txt.2, temp.txt.3.");
		jta.setWrapStyleWord(true);
		jta.setLineWrap(true);
		
		// add textarea, panels, and jbtStart button to the last panel
		panel.add(jta);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(jbtStart);
		
		// add panel to frame
		add(panel);
		
		// add listeners to the two buttons and invoke the appropriate methods for the action
		jbtStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitFile(jtfInputFile.getText(), Integer.parseInt(jtfNumberOfFiles.getText()));
			}
		});
		
		jbtBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create a JFileChoose in order to allow browsing and selecting of a file
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					// get the selected file
					java.io.File file = fileChooser.getSelectedFile();
					jtfInputFile.setText(file.toString());
				}
			}
		});
	}
	
	public void splitFile(String filename, int numberOfPieces){
		try {
			// construct a BufferedInputStream to check for file to be split
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(filename)));
			
			System.out.println("File size: " + input.available() + " bytes");
			long fileSize = input.available();
			int splitFileSize = (int) Math.ceil(1.0 * fileSize / numberOfPieces);
			
			for (int i=1;i<=numberOfPieces;i++){
				// construct new BufferedOutputStream which is used to split the file
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(filename + "." + i)));
				int value;
				int count = 0;
				
				// what is wring if these two conditions are placed in a different order?
				// answer: a single file will be written as the first condition will
				// always be true until EOF
				
				while (count++ < splitFileSize && (value = input.read()) != -1){
					output.write(value);
				}
				output.close();
			}
			input.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Ch19Lab3 frame = new Ch19Lab3();
		frame.setSize(500, 200);
		frame.setTitle("Exercise 19_11: Split a File");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center the frame
		frame.setVisible(true);
	}
}
