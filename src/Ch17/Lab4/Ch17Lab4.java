/**
 * Program: Ch17Lab4.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 4, 2013
 * Purpose: To display a flag image icon with associated text.
 */

package Ch17.Lab4;

import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ch17Lab4 extends JFrame {
	
	private static final long serialVersionUID = 1L; // eclipse complains

	// declare an array of strings for flag titles
	private String[] flagTitle = {"Canada", "China", "Denmark", "France", "Germany", "India", "Norway", "United Kingdom", "United States of America"};
	
	// declare an ImageIcon array for the national flags of 9 countries
	private ImageIcon[] flagImage = new ImageIcon[9];
	
	// declare an array of strings for flag descriptions
	private String[] flagDescription = new String[9];
	
	// declare and create a description panel
	private DescriptionPanel descriptionPanel = new DescriptionPanel();
	
	// the combo list for selecting countries
	private JComboBox<String> jcbo;
	
	// main
	public static void main(String[] args){
		Ch17Lab4 frame = new Ch17Lab4();
		frame.setSize(400,400);
		frame.setTitle("Chapter 17 Lab 4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public Ch17Lab4(){
		// load images into flagImage array
		flagImage[0] = new ImageIcon("archives/Ch17/image/ca.gif");
		flagImage[1] = new ImageIcon("archives/Ch17/image/china.gif");
		flagImage[2] = new ImageIcon("archives/Ch17/image/denmark.gif");
		flagImage[3] = new ImageIcon("archives/Ch17/image/fr.gif");
		flagImage[4] = new ImageIcon("archives/Ch17/image/germany.gif");
		flagImage[5] = new ImageIcon("archives/Ch17/image/india.gif");
		flagImage[6] = new ImageIcon("archives/Ch17/image/norway.gif");
		flagImage[7] = new ImageIcon("archives/Ch17/image/uk.gif");
		flagImage[8] = new ImageIcon("archives/Ch17/image/us.gif");
		
		// set text description
		for(int i = 0; i < 9; i++){
			flagDescription[i] = getDescription(i);
		}
		
		// create items into the combo box
		jcbo = new JComboBox<String>(flagTitle);
		
		// set the default display to be canada
		setDisplay(0);
		
		// add combobox and description panel to the list
		add(new JScrollPane(jcbo), BorderLayout.NORTH);
		add(descriptionPanel, BorderLayout.CENTER);
		
		// register listener
		jcbo.addItemListener(new ItemListener(){
			// handle item selection
			public void itemStateChanged(ItemEvent e){
				setDisplay(jcbo.getSelectedIndex());
			}
		});
	}
		
		// set display information on the description panel
		public void setDisplay(int index){
			descriptionPanel.setTitle(flagTitle[index]);
			descriptionPanel.setImageIcon(flagImage[index]);
			descriptionPanel.setDescription(flagDescription[index]);
		}
		
		private String getDescription(int i){
			StringBuilder result = new StringBuilder();
			
			try {
				Scanner input = new Scanner(new File("archives/Ch17/text/description" + i + ".txt"));
				while (input.hasNext()){
					result.append(input.nextLine() + '\n');
				}
			} catch (IOException ex){
				System.out.println(ex);
			}
			return result.toString();
		}
}
