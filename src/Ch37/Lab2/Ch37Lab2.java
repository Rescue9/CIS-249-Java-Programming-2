/**
 * Program: Ch37Lab2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 6, 2013
 * Purpose: Create a program that will allow the adjustment of spaces between
 * components and allow the change in direction.
 */

package Ch37.Lab2;

// import necessary, predefined classes
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Ch37Lab2 extends JApplet{

	private static final long serialVersionUID = 1L; // eclipse complains
	
	// declare components
	private JTextField jtfDividerSize;
	
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel jPanel1;
	
	private JCheckBox jchkContinuousLayout;
	
	private JRadioButton jrbVertical, jrbHorizontal;
	private ButtonGroup buttonGroup1;
	
	private JSplitPane jSplitPane1;
	private JLabel jLabel1;
	
	public Ch37Lab2(){
		// construct components
		buttonGroup1 = new ButtonGroup();
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jrbHorizontal = new JRadioButton();
		jrbVertical = new JRadioButton();
		jPanel3 = new JPanel();
		jPanel4 = new JPanel();
		jLabel1 = new JLabel();
		jtfDividerSize = new JTextField();
		jchkContinuousLayout = new JCheckBox();
		jSplitPane1 = new JSplitPane();
		
		jPanel1.setLayout(new BorderLayout());
		
		jPanel2.setLayout(new GridLayout(2, 0));
		jPanel2.setBorder(new TitledBorder("Orientation"));
		
		jrbHorizontal.setText("Horizontal");
		buttonGroup1.add(jrbHorizontal);
		
		// add listeners
		jrbHorizontal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				jrbHorizontalActionPerformed(evt);
			}
		});
		
		jPanel2.add(jrbHorizontal);
		
		jrbVertical.setText("Vertical");
		buttonGroup1.add(jrbVertical);
		jrbVertical.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				jrbVerticalActionPerformed(evt);
			}
		});
		
		jPanel2.add(jrbVertical);
		
		// add panels to the frame
		jPanel1.add(jPanel2, BorderLayout.WEST);
		jPanel3.setLayout(new BorderLayout());
		jPanel4.setLayout(new BorderLayout(5, 0));
		jLabel1.setText("Divider Size");
		jPanel4.add(jLabel1, BorderLayout.WEST);
		
		// add listeners
		jtfDividerSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				jtfDividerSizeActionPerformed(evt);
			}
		});
		
		jPanel4.add(jtfDividerSize, BorderLayout.CENTER);
		
		jchkContinuousLayout.setText("Continuous Layout");
		jchkContinuousLayout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				jchkContinuousLayoutActionPerformed(evt);
			}
		});
		
		jPanel4.add(jchkContinuousLayout, BorderLayout.NORTH);
		jPanel3.add(jPanel4, BorderLayout.CENTER);
		jPanel1.add(jPanel3, BorderLayout.CENTER);
		add(jPanel1, BorderLayout.SOUTH);
		add(jSplitPane1, BorderLayout.CENTER);
	}
	
	private void jtfDividerSizeActionPerformed(ActionEvent evt){
		jSplitPane1.setDividerSize(new Integer(jtfDividerSize.getText().trim()).intValue());
	}
	
	private void jchkContinuousLayoutActionPerformed(ActionEvent evt){
		if (jchkContinuousLayout.isSelected())
			jSplitPane1.setContinuousLayout(true);
		else
			jSplitPane1.setContinuousLayout(false);
	}
	
	private void jrbVerticalActionPerformed(ActionEvent evt){
		jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
	}
	
	private void jrbHorizontalActionPerformed(ActionEvent evt){
		jSplitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	}
	
	public static void main(String[] args){
		Ch37Lab2 applet = new Ch37Lab2();
		JFrame frame = new JFrame();
		frame.setTitle("Chapter 37 Lab 2");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center the frame
		frame.setVisible(true);
	}
	

}
