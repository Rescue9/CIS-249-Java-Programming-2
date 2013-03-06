/**
 * Program: Ch37Prog1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Mar 6, 2013
 * Purpose: To create a program that dynamically displays 15 components in a FlowLayout
 */

package Ch37.Prog1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ch37Prog1 extends JApplet {
	
	private static final long serialVersionUID = 1L; // eclipse complains
	
	FlowLayout myLayout = new FlowLayout();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	
	JButton[] jbtComp = new JButton[15];

	JLabel jlblAlign = new JLabel("Alignment");
	JLabel jlblHGap = new JLabel("HGap");
	JLabel jlblVGap = new JLabel("VGap");
	
	String[] strAlignment = {"Left", "Center", "Right"};
	JComboBox<String> jcbAlign = new JComboBox<String>(strAlignment);
	
	JTextField jtfHGap = new JTextField();
	JTextField jtfVGap = new JTextField();
	
	public Ch37Prog1(){
		panel1.setBorder(new TitledBorder("A Container of FlowLayout"));
		panel1.setLayout(myLayout);
		
		for (int i = 0; i < 15; i++){
			jbtComp[i] = new JButton("Component " + i);
			panel1.add(jbtComp[i]);
		}
				
		panel2.setBorder(new TitledBorder("FlowLayout Properties"));
		panel2.setLayout(new BorderLayout());
		
		panel3.setLayout(new GridLayout(3,0));
		panel3.add(jlblAlign);
		panel3.add(jlblHGap);
		panel3.add(jlblVGap);
		
		panel4.setLayout(new GridLayout(3,0));
		panel4.add(jcbAlign);
		panel4.add(jtfHGap);
		panel4.add(jtfVGap);
		
		panel2.add(panel3, BorderLayout.WEST);
		panel2.add(panel4, BorderLayout.CENTER);
		
		
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		
		jcbAlign.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				setFlowAlignment(jcbAlign.getSelectedIndex());				
			}
		});
		
		jtfHGap.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setHGap(Integer.parseInt(jtfHGap.getText()));				
			}
		});
		
		jtfVGap.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVGap(Integer.parseInt(jtfVGap.getText()));
			}
		});
	}
	
	public static void main(String[] args){
		Ch37Prog1 applet = new Ch37Prog1();
		JFrame frame = new JFrame();
		frame.setTitle("Chapter 37 Program 1");
		frame.add(applet, BorderLayout.CENTER);
		frame.setSize(500,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		applet.init();
		applet.start();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	protected void setFlowAlignment(int index){
		myLayout.setAlignment(index);
		panel1.setLayout(myLayout);
		validate();
	}
	
	protected void setHGap(int hgap){
		myLayout.setHgap(hgap);
		panel1.setLayout(myLayout);
		validate();
	}
	
	protected void setVGap(int vgap){
		myLayout.setVgap(vgap);
		panel1.setLayout(myLayout);
		validate();
	}
	

}
