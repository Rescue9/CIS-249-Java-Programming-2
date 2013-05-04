/**
 * Program: CIS249Final.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: May 3, 2013
 * Purpose: To create a horse betting system that logs the information to a data file.
 */

package Final;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CIS249Final extends JApplet {
	
	private static final String WELCOME_TEXT = "Welcome to Racing at Churchill Downs";
	
	private JTextField jtfDisplay = new JTextField();
	private JTextField jtfBet = new JTextField();
	
	private JButton jbtPlaceBet = new JButton("Place a bet");
	private JButton[] jbtPosition = new JButton[4]; 
	
	public CIS249Final() {
		addMenuBar();
	}
	
	public static void main(String[] args){
		CIS249Final applet = new CIS249Final();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CIS-249 Final");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void addMenuBar(){
		// add a menubar to our frame
		JMenuBar mb = new JMenuBar();
		this.setJMenuBar(mb);
		
		
		// add menus to our menubar & set mnemonics
		JMenu jmFile = new JMenu("File");
		JMenu jmEdit = new JMenu("Edit");
		jmFile.setMnemonic('F');
		jmEdit.setMnemonic('E');
		
		// add items to the menus & set mnemonics
		JMenuItem jmiDisplay = new JMenuItem("Display");
		JMenuItem jmiExit = new JMenuItem("Exit Program");
		JMenuItem jmiClear = new JMenuItem("Clear");
		
		jmiDisplay.setMnemonic('D');
		jmiExit.setMnemonic('P');
		jmiClear.setMnemonic('C');
		
		jmFile.add(jmiDisplay);
		jmFile.add(jmiExit);
		jmEdit.add(jmiClear);
		
		// add everything to menubar
		mb.add(jmFile);
		mb.add(jmEdit);
		
		// set actionListeners for menuItems
		jmiDisplay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//execDisplay();
			}
			
		});
		
		jmiExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		
		jmiClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jtfBet.setText("");
				jtfDisplay.setText("");
				System.out.println("Reset Program");			}
		});
	}
}
