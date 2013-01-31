/**
 * Program: Ch19Prog1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 19, 2013
 * Purpose: To combine a number of files into one single file.
 * Example: file.ext.1 + file.ext.2 + file.ext.3 = file.ext
 */

package Ch19.Prog1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;


public class Ch19Prog1 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	private JTextField jtfBaseFile = new JTextField(20);
	private JTextField jtfNumOfFiles = new JTextField(3);
	private JButton	jbtStart	=	new JButton("Start");
	
	public Ch19Prog1(){
		
		// construct base file panel
		JPanel panelBase = new JPanel(new BorderLayout());
		panelBase.add(new JLabel("Enter the base file: "), BorderLayout.WEST);
		panelBase.add(jtfBaseFile, BorderLayout.EAST);
		
		// construct number of files panel
		JPanel panelNumFiles = new JPanel(new BorderLayout());
		panelNumFiles.add(new JLabel("Specify the number of smaller files: "), BorderLayout.WEST);
		panelNumFiles.add(jtfNumOfFiles);
		
		//construct the main panel to hold everything
		JPanel panel = new JPanel(new GridLayout(4,1));
		JTextArea jlb = new JTextArea("Ifthe base file is named temp.txt with three pieces, temp.txt.1, temp.txt.2, and temp.txt.3 are combined into temp.txt");
		jlb.setWrapStyleWord(true);
		jlb.setLineWrap(true);
		
		// add everything to the main panel
		panel.add(jlb);
		panel.add(panelBase);
		panel.add(panelNumFiles);
		panel.add(jbtStart);
		
		// add panel to the frame
		this.add(panel);
		
		// create the actionlistener for the start button
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// checking to make sure that the fields aren't empty
				if (!jtfBaseFile.getText().equals("") && !jtfNumOfFiles.getText().equals("")){
					combineFiles(jtfBaseFile.getText(), Integer.parseInt(jtfNumOfFiles.getText()));
				} else {
					JOptionPane.showMessageDialog(null,"You must enter values into both boxes!");
				}
			}
		});
		
	}
	
	public void combineFiles(String fileName, int numOfFiles){
		try {
			// first, create archive dir if not available.
			File dir = new File("./archives/");
			dir.mkdir();
			
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(dir + "/" + fileName)));
			
			for(int i=1; i<=numOfFiles;i++){
				BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(dir + "/" + fileName + "." + i)));
				int value;
				
				// write output as long as there is a file being read from (value)
				while ((value = input.read()) != -1){
					output.write(value);
				}
				input.close();
			}
			output.close();
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Ch19Prog1 frame = new Ch19Prog1();
		frame.setSize(500, 200);
		frame.setTitle("Chapter 19: Programming assignment #1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
