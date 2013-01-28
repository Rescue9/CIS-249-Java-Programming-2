/**
 * Program: Ch19Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 19, 2013
 * Purpose: Demonstrate the Formatter, FileInputStream, File, FileoutputStream,
 * and StringBuffer classes.
 */

package Ch19.Lab1;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Ch19Lab1 {
	
	public static void main(String[] args){
		
		// the File class links to the name of the file to be read
		File file = new File("Ch19Lab1File.txt");
		
		int ch;
		
		// the StringBuffer class allows you to append to a String of characters
		StringBuffer strContent = new StringBuffer("");
		
		// the FileImputStream class reads the input supplied by the File class
		FileInputStream fin = null;
		
		try {
			// construct a Formatter object that uses the FileOutputStream class to link to
			// the text file to be downloaded to
			Formatter output = new Formatter(new FileOutputStream("Ch19Lab1File.txt", true));
			
			// generate 100 random numbers
			for (int i = 0; i < 100; i++){
				output.format("%d", (int)(Math.random()* 1000000)); // the %d formats to an integer
			}
			
			// always close the stream
			output.close();
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null, "Error creating file");
		}
		
		// notify the user that the download is complete
		JOptionPane.showMessageDialog(null, "Output Complete");
		
		try {
			fin = new FileInputStream(file);
			
			// while there is anything to read through FileInputStream
			// append to the StringBuffer
			while ((ch = fin.read()) != -1){
				strContent.append((char)ch);
			}
			
			// close the stream
			fin.close();
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "File Fot Found. Check the name of the file");
		}
		catch (IOException ioe){
			System.out.println("Error reading the file " + ioe);
		}
		
		// display the contents
		System.out.println(strContent);
	}

}
